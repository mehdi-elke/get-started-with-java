package fr.baretto.tp3;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(price, order.price) == 0 && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishes, order.dishes) && Objects.equals(deliveryPlace, order.deliveryPlace);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public double getPrice() {
        return price;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }
}
