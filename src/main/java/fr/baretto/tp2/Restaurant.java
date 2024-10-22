package fr.baretto.tp2;

import java.util.*;

public class Restaurant {
    private String name;
    private List<Observer> observers;

    public Restaurant(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void prepareOrder(List<Dish> dishes, double price, String deliveryPlace) throws InterruptedException {
        Thread.sleep(new Random().nextInt(3000));
        Map<Dish, Integer> dishesMap = new HashMap<>();
        for(Dish dish : dishes){
            dishesMap.merge(dish, 1, Integer::sum);
        }
        this.notifyObservers("finished order", new Order(this, dishesMap, price, deliveryPlace));
    }

    public void notifyObservers(String event, Order order){
        this.observers.forEach(observer -> {
            try {
                observer.update(event, order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
}
