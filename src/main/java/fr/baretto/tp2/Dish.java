package fr.baretto.tp2;

public class Dish {

    private String name ;
    private DishSize size;

    public Dish (String name , DishSize size ){
        this.name =name ;
        this.size = size ;
    }

    public String getName() {
        return this.name;
    }

    public DishSize getSize() {
        return this.size;
    }

}
