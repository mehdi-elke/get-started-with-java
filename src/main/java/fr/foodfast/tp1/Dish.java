package fr.foodfast.tp1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Dish dish = (Dish) obj;
        return Objects.equals(name, dish.name) &&
                size == dish.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
