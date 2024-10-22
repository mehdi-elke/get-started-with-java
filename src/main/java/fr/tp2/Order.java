package fr.tp2;

import java.util.Map;

public class Order {

    public final Restaurant restaurant;
    public final Map<Dish, Integer> dishes;
    public final String address;
    public OrderStatus status;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, String address, OrderStatus status) {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.address = address;
        this.status = status;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public double getTotal() {
        return dishes.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }
}