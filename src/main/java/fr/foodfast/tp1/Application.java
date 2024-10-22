package fr.foodfast.tp1;

public class Application {
    public static void main(String[] args) {
        DeliveryPlatform livraison = new DeliveryPlatform();
        Restaurant restaurant = new Restaurant("Chez l'ancien");

        // Commande test 1
        Order order = restaurant.prepareOrder(1,"Lille", new Dish("Pizza", Dish.Size.L), 3, 20, restaurant.getName());
        restaurant.notifyOrder(order);

        // Commande test 2
        Order order1 = restaurant.prepareOrder(2,"Paris", new Dish("Tacos", Dish.Size.M), 1, 11, restaurant.getName());
        restaurant.notifyOrder(order1);

    }
}




