package fr.foodfast.tp1;

import java.util.Random;

public class Restaurant {

    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void notifyOrder(Order order, DeliveryPlatform livraison) {
        livraison.update(order);
    }

    public Order prepareOrder(int id, String location, Dish dish, int quantity, int price, String place) {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Order(id, location, dish, quantity, price, place);
    }
}