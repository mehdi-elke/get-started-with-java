package tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Restaurant {
    private String name;
    private EventBus eventBus;

    public Restaurant(String name, EventBus eventBus) {
        this.name = name;
        this.eventBus = eventBus;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(Map<Dish, Integer> dishes, double price, String deliveryLocation) {
        try {
            Thread.sleep(new Random().nextInt(3000)); // Simule le temps de préparation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = new Order(this, dishes, price, deliveryLocation);
        eventBus.publishEvent(order); // Publier l'événement
        return order;
    }
}
