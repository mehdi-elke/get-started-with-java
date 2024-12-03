package fr.tp2;

public class NotificationService {
    public static  void sendNotification(Customer customer,String message) {
        System.out.println("Notification envoyée : " + customer.getPhoneNumber() + ">" +message);
    }

}
