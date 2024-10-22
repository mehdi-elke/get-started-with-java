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

    public Order prepareOrder() {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Order(this);
    }
}