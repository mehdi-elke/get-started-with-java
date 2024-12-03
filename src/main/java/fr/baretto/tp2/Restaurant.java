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

    public void notifyObservers(Order order) {
        for (DeliveryPlateform observer : observers) {
            observer.update(order);
        }
    }

    public Order prepareOrder(Dish dish, int quantity, double initialPrice, String address) {
        try {
            if (new Random().nextInt(100) < 20) { // 20% de probabilité d'échec
                throw new OrderPreparationException("Échec de la préparation de la commande.");
            }
            this.getDeliveryTime();
            Order order = new Order(this, dish, quantity, initialPrice, address);
            notifyObservers(order);
            return order;
        } catch (OrderPreparationException e) {
            ErrorManagementService.logError(e.getMessage());
            System.out.println("Erreur : " + e.getMessage());
            return null; // Retourne null pour signaler l'échec
        }
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
