package Tp2;

import java.util.Random;

public class Restaurant {

    private String name;

    public Order prepareOrder(Dish dish, int quantity, int price, String address) throws InterruptedException {
        Thread.sleep(new Random().nextInt(3000));
        return new Order(this, dish, quantity, price, address);
    }
}
