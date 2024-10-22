package fr.foodfast.tp1;

public class Dish {

    public enum Size {
        S,
        M,
        L
    }

    private String name;
    private Size size;

    public Dish(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }
}