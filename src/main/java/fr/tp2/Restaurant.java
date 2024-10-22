package fr.tp2;

import java.util.Random;

public class Restaurant {
    private final String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(Order order) throws InterruptedException {
        System.out.println("Preparing order for " + order.getAddress());
        order.status = OrderStatus.PREPARING;
        Thread.sleep(new Random().nextInt(3000));
        order.status = OrderStatus.READY_FOR_DELIVERY;

        sendNotif(order);

        return order;
    }

    public void sendNotif(Order order){
        if(order.getStatus() == OrderStatus.READY_FOR_DELIVERY){
            order.status = OrderStatus.DELIVERED;
            System.out.println("Order is ready for delivery");
        }

    }
}