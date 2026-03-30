package q3;
//TODO: Remove direct dependency on SMSService
//Depend on NotificationService abstraction
//Use constructor injection
public class AppointmentManager {
    private SMSService smsService = new SMSService();

    public void notifyPatient(String message) {
        smsService.sendSMS(message);
    }
}

