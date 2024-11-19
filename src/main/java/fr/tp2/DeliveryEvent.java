package fr.tp2;

public class DeliveryEvent implements Event {
    private Order order;
    private OrderStatus status;
    public DeliveryEvent(Order order, OrderStatus status) {
        this.order = order;
        this.status = status;
    }
    @Override
    public void handleEvent(Order order) {
        System.out.println("Changement de status de la commande " + order.getId() + " : " + status);
    }
}
