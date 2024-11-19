package tp2;

import java.util.Map;
import java.util.UUID;

public class Order {

    private final String id; // Unique identifier for the order
    private Restaurant restaurant;
    private Map<Dish, Integer> dishes;
    private double price;
    private String deliveryLocation;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, double price, String deliveryLocation) {
        this.id = UUID.randomUUID().toString();
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.price = price;
        this.deliveryLocation = deliveryLocation;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", restaurant=" + restaurant.getName() +
                ", dishes=" + dishes.toString() +
                ", price=" + price +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                '}';
    }
}
