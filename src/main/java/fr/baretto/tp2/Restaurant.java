package fr.baretto.tp2;

import java.util.HashMap;
import java.util.List;
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

    public Order prepareOrder(List<Dish> dishes, double price, String deliveryPlace) throws InterruptedException {
        Thread.sleep(new Random().nextInt(3000));
        Map<Dish, Integer> dishesMap = new HashMap<>();
        for(Dish dish : dishes){
            dishesMap.merge(dish, 1, Integer::sum);
        }
        return new Order(this, dishesMap, price, deliveryPlace);
    }
}
