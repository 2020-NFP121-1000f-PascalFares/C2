package glg203.demoJFX.demo1;

public class MyMessageSource implements IMessageSource {
    
    private static IMessageSource instance= new MyMessageSource();

    public static IMessageSource getInstance() {
        return instance;
    }
    
    @Override
    public String getMessage() {
        return "Cette application montre le probl�me qu'on � passer "
                + "une source de messages � une application JavaFx.\n"+
        "Comme l'application la m�thode FXMLLoader.load instancie "
                + "le App1Controller, on ne peut pas facilement passer de "
                + "donn�es � celui-ci...\n"
                + "Ici, le contr�leur utilise directement le MyMessageSource...";
    }
    
}