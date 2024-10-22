package fr.foodfast.tp1;

public class Application {
    public static void main(String[] args) {
        DeliveryPlatform livraison = new DeliveryPlatform();
        Restaurant restaurant = new Restaurant("Restaurant Gourmet");
        for (int i = 0; i < 5; i++) {
            Order order = restaurant.prepareOrder();
            livraison.delivery(order);
        }
    }
}

print("Hello, World!");


