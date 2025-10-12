package ComputerScienceCenter.lection4.a;

public abstract class AbstractGreeter {
    private final String recipient;

    protected AbstractGreeter(String recipient) {
        this.recipient = recipient;
    }
    protected void hello() {
        System.out.println("Hello " + recipient + "!");
    }
}
