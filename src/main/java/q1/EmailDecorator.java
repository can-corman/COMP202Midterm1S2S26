package q1;

public class EmailDecorator extends NotifierDecorator {

    public EmailDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // TODO:
        // 1. Call parent behavior
        super.send(message);
        // 2. Add email sending functionality
        System.out.println("Sending EMAIL: ");
    }
}
