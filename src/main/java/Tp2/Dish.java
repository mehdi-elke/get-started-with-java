package Tp2;

public class Dish {
    private String name;
    private Height size;
    public Dish(String name, Height t) {
        this.name = name;
        this.size = t;
    }
    public String getName() {return name;}
    public Height getSize() {return size;}
}