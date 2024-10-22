package tp2;

import java.util.Map;

public class Order {

    private Restaurant restaurant;
    private Map<Dish, Integer> dishes;
    private double price;
    private String deliveryLocation;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, double price, String deliveryLocation) {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.price = price;
        this.deliveryLocation = deliveryLocation;
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

    public String getDeliveryLocation() {
        return deliveryLocation;
    }
}
