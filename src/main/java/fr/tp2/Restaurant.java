package fr.tp2;

import java.util.*;

public class Restaurant {
    private final String name;
    private final Set<String> orderIds = new HashSet<>();

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
        EventBus.handleEvent(order);

        return order;
    }
}