package q3;
//TODO: Remove direct dependency on SMSService
//Depend on NotificationService abstraction
//Use constructor injection
public class AppointmentManager {

    public NotificationService service;
    public AppointmentManager manager;

    public AppointmentManager(NotificationService service) {

    }


    public void notifyPatient(NotificationService service, String message) {
        service.send(message);
    }
}

