package q3;
//TODO: Implement the NotificationService interface
//Adapt existing method accordingly
public class SMSService implements NotificationService {

    public SMSService smsService = new SMSService();

    @Override
    public void send(String message){
        System.out.println("Sending SMS: " + message);
    };
}

