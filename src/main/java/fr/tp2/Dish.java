package fr.tp2;

public class Dish {

    public enum DishEnum {
        S,
        M,
        L,
    }
    private final String name;
    private final DishEnum size;
    private final double price;

    public Dish(String name, DishEnum size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public DishEnum getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}