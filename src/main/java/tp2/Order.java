package tp2;

import java.util.Map;

public class Order {

    private Restaurant restaurant;
    private Map<Dish, Integer> dishes;
    private double amount;
    private String deliveryLocation;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, double amount, String deliveryLocation) {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.amount = amount;
        this.deliveryLocation = deliveryLocation;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public double getAmount() {
        return amount;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }
}
