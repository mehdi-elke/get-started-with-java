package fr.baretto.tp2;

import java.util.Map;

public class Order {
    private Restaurant restaurant;
    private Map<Dish, Integer> dishes;
    private double price;
    private String deliveryPlace;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, double price, String deliveryPlace) {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.price = price;
        this.deliveryPlace = deliveryPlace;
    }
}
