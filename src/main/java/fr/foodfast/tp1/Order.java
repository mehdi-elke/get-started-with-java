package fr.foodfast.tp1;

public class Order {

    private int id;
    private String location;
    private Dish dish;
    private int quantity;
    private int price;
    private String place;

    public Order(int id, String location, Dish dish, int quantity, int price, String place) {
        this.id = id;
        this.location = location;
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
        this.place = place;
    }

    public String getLocation() {
        return location;
    }

    public String getPlace() {
        return place;
    }

    public int getAmount() {
        return price * quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }
}
