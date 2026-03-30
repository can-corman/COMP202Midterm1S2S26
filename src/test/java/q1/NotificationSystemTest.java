package q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotificationSystemTest {

    // Helper method to capture console output
    private String getOutput(Runnable task) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            task.run();
        } finally {
            System.setOut(originalOut);
        }

        return outputStream.toString().trim();
    }

    // -----------------------------
    //  Task 1: Decorator Behavior
    // -----------------------------

    @Test
    void testBasicNotifier() {
        Notifier notifier = new BasicNotifier();

        String output = getOutput(() ->
                notifier.send("Hello")
        );

        assertEquals("Basic notification: Hello", output);
    }

    @Test
    void testEmailDecorator() {
        Notifier notifier = new EmailDecorator(new BasicNotifier());

        String output = getOutput(() ->
                notifier.send("Hello")
        );

        assertTrue(output.contains("Basic notification: Hello"));
        assertTrue(output.contains("Sending EMAIL: Hello"));
    }

    @Test
    void testSMSDecorator() {
        Notifier notifier = new SMSDecorator(new BasicNotifier());

        String output = getOutput(() ->
                notifier.send("Hello")
        );

        assertTrue(output.contains("Basic notification: Hello"));
        assertTrue(output.contains("Sending SMS: Hello"));
    }

    @Test
    void testLoggingDecorator() {
        Notifier notifier = new LoggingDecorator(new BasicNotifier());

        String output = getOutput(() ->
                notifier.send("Hello")
        );

        // Logging should happen BEFORE sending
        String[] lines = output.split("\n");

        assertEquals("LOG: Hello", lines[0].trim());
        assertEquals("Basic notification: Hello", lines[1].trim());
    }

    // ----------------------------------------
    //  Decorator Chain (Order Matters)
    // ----------------------------------------

    @Test
    void testFullDecoratorChainOrder() {

        Notifier notifier =
                new LoggingDecorator(
                        new EmailDecorator(
                                new SMSDecorator(
                                        new BasicNotifier()
                                )
                        )
                );

        String output = getOutput(() ->
                notifier.send("Exam system deployed")
        );

        String[] lines = output.split("\n");

        assertEquals("LOG: Exam system deployed", lines[0].trim());
        assertEquals("Basic notification: Exam system deployed", lines[1].trim());
        assertEquals("Sending SMS: Exam system deployed", lines[2].trim());
        assertEquals("Sending EMAIL: Exam system deployed", lines[3].trim());
    }

    // ----------------------------------------
    // Common Mistake Detection
    // ----------------------------------------

    @Test
    void testDecoratorMustDelegate() {
        Notifier notifier = new EmailDecorator(new BasicNotifier());

        String output = getOutput(() ->
                notifier.send("Test")
        );

        // If student forgets super.send(), this will fail
        assertTrue(output.contains("Basic notification: Test"),
                "Decorator must delegate to wrapped object");
    }

    // -----------------------------
    //  Singleton Tests
    // -----------------------------

    @Test
    void testSingletonInstanceNotNull() {
        NotificationService instance = NotificationService.getInstance();
        assertNotNull(instance);
    }

    @Test
    void testSingletonSameInstance() {
        NotificationService instance1 = NotificationService.getInstance();
        NotificationService instance2 = NotificationService.getInstance();

        assertSame(instance1, instance2,
                "getInstance() should always return the same object");
    }

    // ----------------------------------------
    // Integration Test (Decorator + Singleton)
    // ----------------------------------------

    @Test
    void testNotificationServiceWithDecorators() {

        Notifier notifier =
                new EmailDecorator(
                        new BasicNotifier()
                );

        NotificationService service = NotificationService.getInstance();

        String output = getOutput(() ->
                service.sendNotification(notifier, "Integration Test")
        );

        assertTrue(output.contains("Basic notification: Integration Test"));
        assertTrue(output.contains("Sending EMAIL: Integration Test"));
    }
}
