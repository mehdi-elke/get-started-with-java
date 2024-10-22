package fr.tp2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Restaurant mcDonalds = new Restaurant("McDonald's");
        Restaurant subway = new Restaurant("Subway");

        Dish sub30terryaki = new Dish("30cm Teriyaki",  Dish.DishEnum.L, 10.0);
        Dish sub15bmt = new Dish("15cm BMT",  Dish.DishEnum.M, 5.0);
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Dish mcNuggets = new Dish("McNuggets", Dish.DishEnum.S, 6.0);

        Order order1 = new Order(mcDonalds, (new ListDishes())
                .addDish(bigMac, 1)
                .addDish(mcNuggets, 3)
                .getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        Order order2 = new Order(subway, (new ListDishes())
                .addDish(sub30terryaki, 1)
                .addDish(sub15bmt, 2)
                .getDishes(), "5 rue de Paris", OrderStatus.TO_PREPARE);

        DeliveryPlatform platform = new DeliveryPlatform();
        platform.delivery(order1);
        platform.delivery(order2);
    }
}