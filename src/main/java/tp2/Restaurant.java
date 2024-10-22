package tp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Restaurant {
    private String name;

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

        return new Order(this, dishes,price, deliveryLocation);
    }
}
