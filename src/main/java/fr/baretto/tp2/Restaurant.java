package fr.baretto.tp2;

import java.util.Random;

public class Restaurant {
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(Dish dish, int quantity, double initialPrice, String address) {
        this.getDeliveryTime();
        return new Order(this, dish, quantity, initialPrice, address);
    }

    public void getDeliveryTime() {
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
