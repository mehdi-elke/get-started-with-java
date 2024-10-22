package fr.baretto.tp2;

public class Dish {

    private String name;
    private enum size {S, M, L};

    public Dish(String name, double v) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}