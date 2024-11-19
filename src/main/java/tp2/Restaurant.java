package tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Restaurant implements Subject {
    private String name;
    private List<Observer> observers = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(Map<Dish, Integer> dishes, double price, String deliveryLocation) {
        try {
            Thread.sleep(new Random().nextInt(3000)); // simulate preparation time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = new Order(this, dishes, price, deliveryLocation);
        notifyObservers(order); // Notify observers when an order is prepared
        return order;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Order order) {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}
