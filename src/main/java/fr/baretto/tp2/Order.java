package fr.baretto.tp2;

public class Order {
    private Restaurant restaurant;
    private Dish dish;
    private int quantity;
    private double initialPrice;
    private String address;

    public Order(Restaurant restaurant, Dish dish, int quantity, double initialPrice, String address) {
        this.restaurant = restaurant;
        this.dish = dish;
        this.quantity = quantity;
        this.initialPrice = initialPrice;
        this.address = address;
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

    public void setInitialPrice(float initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
