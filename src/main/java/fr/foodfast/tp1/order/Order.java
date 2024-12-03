package fr.foodfast.tp1.order;

import fr.foodfast.tp1.Dish;

public class Order {
    private int id;
    private String location;
    private Dish dish;
    private int quantity;
    private int price;
    private String address;

    public Order(int id, String location, Dish dish, int quantity, int unitPrice, String address) {
        this.id = id;
        this.location = location;
        this.dish = dish;
        this.quantity = quantity;
        this.price = unitPrice * quantity; // Calculate total price
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }
}