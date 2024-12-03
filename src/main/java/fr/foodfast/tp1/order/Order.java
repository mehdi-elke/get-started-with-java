package fr.foodfast.tp1.order;

import fr.foodfast.tp1.Dish;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Order order = (Order) obj;
        return id == order.id &&
                quantity == order.quantity &&
                price == order.price &&
                Objects.equals(location, order.location) &&
                Objects.equals(dish, order.dish) &&
                Objects.equals(place, order.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, dish, quantity, price, place);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", dish=" + dish +
                ", quantity=" + quantity +
                ", price=" + price +
                ", place='" + place + '\'' +
                '}';
    }
}
