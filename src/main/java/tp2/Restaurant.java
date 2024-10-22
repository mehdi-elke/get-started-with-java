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

    public Order prepareOrder() {
        try {
            Thread.sleep(new Random().nextInt(3000)); // simulate preparation time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<Dish, Integer> dishes = new HashMap<>(); // add some dishes
        double amount = 100.0; // example amount
        String deliveryLocation = "123 Main St";

        return new Order(this, dishes, amount, deliveryLocation);
    }
}
