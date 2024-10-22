package fr.tp2;

public class DeliveryPlatform {
    public void delivery(Order order) throws InterruptedException {
        order.getRestaurant().prepareOrder(order);
    }
}