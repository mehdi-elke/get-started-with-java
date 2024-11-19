package tp2;

public class DeliveryPlatform implements Observer {

    @Override
    public void update(Order order) {
        System.out.println("Notification received: A new order has been prepared: " + order);
        delivery(order);
    }

    public void delivery(Order order) {
        System.out.println("La commande est livrée: " + order);
    }
}
