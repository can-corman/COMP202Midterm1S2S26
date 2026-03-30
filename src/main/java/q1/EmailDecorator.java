package q1;

public class EmailDecorator extends NotifierDecorator {

    public EmailDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // TODO:
        // 1. Call parent behavior
        // 2. Add email sending functionality
    }
}
