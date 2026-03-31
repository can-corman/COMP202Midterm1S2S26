package q1;

public class LoggingDecorator extends NotifierDecorator {

    public LoggingDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // TODO:
        // 1. Log the message BEFORE sending
        System.out.println("LOG: ");

        // 2. Call parent behavior
        super.send(message);
    }
}
