<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Notifications asynchrones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Exemple pris sur             
            <a href="http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/async-servlet/async-servlets.html">Using Asynchronous Servlets for Web Push Notifications</a>
        </div>


        <div style="width: 20em; float: right; border-left: solid 1pt gray; padding: 1ex;">
            <p><em>Principe</em> : lors du premier affichage de la
                page, celle-ci affiche la liste des messages en utilisant le bean 
                application "messages".</p>
            <p>Pour la suite : </p>
            <ul>
                <li>Toutes les secondes, <strong>si on n'est pas d�j� en attente,</strong>
                    on envoie une requ�te GET. Celle-ci sera trait�e de mani�re asynchrone
                    (dans l'imm�diat, tout ce qui se passe, c'est la cr�ation d'un AsyncContext, qui sera 
                    conserv� jusqu'� ce qu'il soit utilis� lors du prochain POST).
                </li>
                <li>Quand on envoie un nouveau message, on ex�cute un POST ; la liste "messages" est 
                    alors mise � jour (ce qui ne sera utilis� que par les nouvelles connexions au site). Mais surtout, 
                    tous les AsyncMessages en attente sont renvoy�s avec le texte du nouveau message.</li>
            </ul>
            <p> Le logiciel actuel �vite de surcharger le serveur : un client ne fait qu'une requ�te � la fois.
                Il n'est pas tr�s robuste, cependant. Si un message est post� avant que getMessage ne soit rappel�, 
                ce message passera � la trappe (essayez en fixant l'intervalle de getMessage 
                � une valeur de 20000 pour 20 seconde).                
            </p>
            <p> Une solution plus robuste serait, pour chaque requ�te, de conna�tre le num�ro du dernier message
                affich� par la page actuelle... ou tout b�tement de tout r�afficher, mais ce sera plus co�teux.</p>
        </div>

        <h1>Messages !</h1>
        nom <input type="text" name="name" id="name"/> <br/>
        message <input type="text" name="message" id="message"/><br/>
        <button onclick="envoyer()">envoyer</button>

        <h1>Messages actuels</h1>
        <div id="content">
            <c:if test="${not empty messages}">
                ${messages} <!-- pas beau du tout !!!-->
            </c:if>
        </div>

        <script>
            function envoyer() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("POST", "shout?t=" + new Date(), false);
                xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                var nameText = escape(document.getElementById("name").value);
                var messageText = escape(document.getElementById("message").value);
                document.getElementById("message").value = "";
                xmlhttp.send("name=" + nameText + "&message=" + messageText);
            }

            var waitingMessages = false;
            function getMessages() {
                if (!waitingMessages) {
                    waitingMessages = true;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            waitingMessages = false;
                            var contentElement = document.getElementById("content");
                            contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                        }
                    };
                    xmlhttp.open("GET", "shout?t=" + new Date(), true);
                    xmlhttp.send();
                }
            }
            setInterval(getMessages, 1000);
        </script>

    </body>
</html>
