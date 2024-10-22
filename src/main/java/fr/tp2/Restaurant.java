package fr.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Random;

public class Restaurant {
    private final String name;
    private final List<OrderObserver> observers = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public Order prepareOrder(Order order) throws InterruptedException {
        System.out.println("Preparing order for " + order.getAddress());
        order.status = OrderStatus.PREPARING;
        Thread.sleep(new Random().nextInt(3000));
        order.status = OrderStatus.READY_FOR_DELIVERY;

        notifyObservers(order);

        return order;
    }

    private void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }
}