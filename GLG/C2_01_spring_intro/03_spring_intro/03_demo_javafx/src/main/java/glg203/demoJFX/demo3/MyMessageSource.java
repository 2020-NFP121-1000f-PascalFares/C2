package glg203.demoJFX.demo3;



public class MyMessageSource implements IMessageSource {
    
    @Override
    public String getMessage() {
        return "Dans cette version, on a bricol� un annuaire.\n"
                + "C'est lui qui est un singleton, maintenant, et on peut y copier les"
                + " impl�mentations qu'on veut.";
    }
    
}