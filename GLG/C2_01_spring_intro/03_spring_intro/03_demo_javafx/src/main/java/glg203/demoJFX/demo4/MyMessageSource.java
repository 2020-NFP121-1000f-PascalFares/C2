package glg203.demoJFX.demo4;

public class MyMessageSource implements IMessageSource {

    @Override
    public String getMessage() {
        return "Dans cette version, plus propre, on utilise l'injection de d�pendance pour injecter le bon MessageSource.\n"+
        "Le syst�me est encore assez bancal... la cr�ation du contr�leur supporterait mal une architecture plus complexe.\n"+
        "Remarque: on a en fait deux syst�mes d'injection de d�pendances. Le n�tre (tr�s sommaire), et celui de FXMLLoader."
        ;
    }
    
}