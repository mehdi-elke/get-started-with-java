package fr.baretto.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant {
    private String name;
    private final List<DeliveryPlateform> observers;

    public Restaurant(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addObserver(DeliveryPlateform observer) {
        observers.add(observer);
    }

    public void removeObserver(DeliveryPlateform observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Order order) throws DeliveryProcessingException {
        for (DeliveryPlateform observer : observers) {
            observer.update(order);
        }
    }

    public Order prepareOrder(Dish dish, int quantity, double initialPrice, String address, Customer customer) throws OrderPreparationException, DeliveryProcessingException {
        if (new Random().nextInt(100) < 20) {
            throw new OrderPreparationException("Échec de la préparation de la commande de la part du restaurant.");
        }
        this.getDeliveryTime();
        Order order = new Order(this, dish, quantity, initialPrice, address, customer);
        notifyObservers(order);
        return order;
    }


    public void getDeliveryTime() {
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DeliveryPlateform> getObservers() {
        return observers;
    }

}
