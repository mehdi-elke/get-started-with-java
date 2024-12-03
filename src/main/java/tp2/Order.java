package tp2;
import java.util.Map;
import java.util.UUID;

public class Order {
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    private UUID id;
    private Restaurant restaurant;
    private Map<Dish, Integer> dishes;
    private double amount;
    private String deliveryLocation;
    private Customer customer;
    private Status status;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, double amount, String deliveryLocation, Customer customer) {
        this.id = UUID.randomUUID();
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.amount = amount;
        this.deliveryLocation = deliveryLocation;
        this.customer = customer;
        this.status = Status.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public void setDishes(Map<Dish, Integer> dishes) {
        this.dishes = dishes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}