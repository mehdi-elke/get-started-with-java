package fr.tp2;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Order implements Subscribable {

    public final Restaurant restaurant;
    public final Map<Dish, Integer> dishes;
    public final String address;
    private OrderStatus status;
    public String uuid;
    public Customer customer;

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, String address, OrderStatus status, Customer customer) throws Throwable {
        this(restaurant, dishes, address, status, customer, generateUUID4());
    }

    public Order(Restaurant restaurant, Map<Dish, Integer> dishes, String address, OrderStatus status, Customer customer, String uuid) throws Throwable {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.address = address;
        this.status = status;
        this.uuid = uuid;
        this.customer = customer;

        EventBus.handleEvent(EventType.ORDER, this);
    }

    public String getId() {
        return uuid;
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

    public static String generateUUID4() {
        return java.util.UUID.randomUUID().toString();
    }

    public Order setStatus(OrderStatus status) throws Throwable {

        if (this.status != OrderStatus.IN_ERROR) {
            this.status = status;
        }
        EventBus.handleEvent(EventType.DELIVERY, this);
        return this;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}