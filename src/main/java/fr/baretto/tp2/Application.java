package fr.baretto.tp2;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = new Restaurant("FoodFast");
        DeliveryPlateform foodFastLivraison = new DeliveryPlateform();
        Dish pates = new Dish("pâtes", DishSize.M);
        Dish lasagnes = new Dish("lasagnes", DishSize.L);
        Dish pizza = new Dish("pizza", DishSize.S);



        restaurant.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille");


    }
}
