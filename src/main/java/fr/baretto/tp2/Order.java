package fr.baretto.tp2;

import java.util.Objects;

public class Order {
    private Restaurant restaurant;
    private Dish dish;
    private int quantity;
    private double initialPrice;
    private String address;
    private final Customer customer; // Nouveau champ

    public Order(Restaurant restaurant, Dish dish, int quantity, double initialPrice, String address, Customer customer) {
        this.restaurant = restaurant;
        this.dish = dish;
        this.quantity = quantity;
        this.initialPrice = initialPrice;
        this.address = address;
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Double.compare(order.initialPrice, initialPrice) == 0 &&
                Objects.equals(restaurant, order.restaurant) &&
                Objects.equals(dish, order.dish) &&
                Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant, dish, quantity, initialPrice, address);
    }
}