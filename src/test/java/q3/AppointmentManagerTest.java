package q3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import q1.NotificationService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppointmentManagerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSMSNotification() {
        // Arrange
        NotificationService smsService = new SMSService();
        AppointmentManager manager = new AppointmentManager(smsService);

        // Act
        manager.notifyPatient("Your appointment is tomorrow.");

        // Assert
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Sending SMS: Your appointment is tomorrow."),
                "SMSService should send correct message");

        // Reset output
        outputStream.reset();
    }

    @Test
    void testEmailNotification() {
        // Arrange
        NotificationService emailService = new EmailService();
        AppointmentManager manager = new AppointmentManager(emailService);

        // Act
        manager.notifyPatient("Your appointment is tomorrow.");

        // Assert
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Sending Email: Your appointment is tomorrow."),
                "EmailService should send correct message");

        // Reset output
        outputStream.reset();
    }

    @Test
    void testDIPImplementationWithMultipleServices() {
        // Arrange
        NotificationService smsService = new SMSService();
        NotificationService emailService = new EmailService();

        AppointmentManager smsManager = new AppointmentManager(smsService);
        AppointmentManager emailManager = new AppointmentManager(emailService);

        // Act
        smsManager.notifyPatient("SMS Test");
        emailManager.notifyPatient("Email Test");

        String output = outputStream.toString().trim();

        // Assert
        assertTrue(output.contains("Sending SMS: SMS Test"),
                "AppointmentManager should use NotificationService abstraction for SMS");
        assertTrue(output.contains("Sending Email: Email Test"),
                "AppointmentManager should use NotificationService abstraction for Email");
    }

    // Clean up System.out
    @org.junit.jupiter.api.AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
}