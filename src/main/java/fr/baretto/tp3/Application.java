package fr.baretto.tp3;

import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        Restaurant restaurant = new Restaurant("FoodFast", eventBus);
        DeliveryPlateform foodFastLivraison = new DeliveryPlateform();
        eventBus.subscribe(foodFastLivraison);
        Dish pates = new Dish("pâtes", DishSize.M);
        Dish lasagnes = new Dish("lasagnes", DishSize.L);
        Dish pizza = new Dish("pizza", DishSize.S);



        restaurant.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille");
        restaurant.prepareOrder(List.of(pates, pizza), 30, "Lille");
        restaurant.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille");

    }
}
