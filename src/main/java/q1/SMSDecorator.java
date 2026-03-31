package q1;

public class SMSDecorator extends NotifierDecorator {

    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // TODO:
        // 1. Call parent behavior
        super.send(message);
        // 2. Add SMS sending functionality
        System.out.println("Sending SMS: ");

    }
}
