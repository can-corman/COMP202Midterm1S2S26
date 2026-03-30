package q1;

public class NotificationService {

    private static NotificationService instance;

    private NotificationService() {
        // private constructor
    }

    public static NotificationService getInstance() {
        // TODO:
        // Ensure only one instance is created
       return null;
    }

    public void sendNotification(Notifier notifier, String message) {
        notifier.send(message);
    }
}
