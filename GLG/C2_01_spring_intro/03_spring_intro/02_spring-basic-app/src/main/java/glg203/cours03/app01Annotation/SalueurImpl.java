package glg203.cours03.app01Annotation;

/**
 * SalueurImpl
 */
public class SalueurImpl implements ISalueur{
    private final IMessageHolder messageHolder;
    public SalueurImpl(IMessageHolder messageHolder) {
        this.messageHolder = messageHolder;
    }
    @Override
    public void saluer() {
        System.out.print("Voici un message : ");
        System.out.println(messageHolder.getMessage());
    }
}