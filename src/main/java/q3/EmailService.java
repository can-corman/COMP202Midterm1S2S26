package q3;

//TODO: Create a class named EmailService.
//
//Requirements:
//
//Must implement NotificationService
//Print: "Sending Email: " + message
    public class EmailService implements NotificationService {

    public EMailService emailService = new EMailService();

    @Override
    public void send(String message){
        System.out.println("Sending EMail: " + message);
    };
}
