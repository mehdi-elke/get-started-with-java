package fr.tp2;

public class DeliveryPlatform implements OrderObserver {
    public void delivery(Order order) throws InterruptedException {
        order.getRestaurant().prepareOrder(order);
    }

    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.READY_FOR_DELIVERY) {
            order.status = OrderStatus.DELIVERED;
            System.out.println("Order is ready for delivery to " + order.getAddress());
        }
    }
}