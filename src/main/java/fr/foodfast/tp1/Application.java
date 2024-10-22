package fr.foodfast.tp1;

public class Application {
    public static void main(String[] args) {
        DeliveryPlatform livraison = new DeliveryPlatform();

        Restaurant resto1 = livraison.subscribeRestaurant(new Restaurant("Chez l'ancien"));
        Restaurant resto2 = livraison.subscribeRestaurant(new Restaurant("Point Sandwich"));
        Restaurant resto3 = livraison.subscribeRestaurant(new Restaurant("Subway"));

        // Commande test 1
        Order order = resto1.prepareOrder(1, resto1.getName(), new Dish("Pizza", Dish.Size.L), 3, 20, "3 rue de la paix, 75010 Paris");
        resto1.notifyOrder(order, livraison);

        // Commande test 2
        Order order1 = resto2.prepareOrder(2,resto2.getName(), new Dish("Tacos", Dish.Size.M), 1, 11, "55 boulevard de la république, 75004 Paris");
        resto2.notifyOrder(order1, livraison);

        // Commande test 3
        Order order3 = resto3.prepareOrder(3,resto3.getName(), new Dish("Kebab", Dish.Size.S), 6, 51, "10 rue des génies, 13001 Marseille");
        resto3.notifyOrder(order3, livraison);

        // Test doublon
        Order order4 = resto3.prepareOrder(4,resto3.getName(), new Dish("Kebab", Dish.Size.S), 6, 51, "15 bd Vauban, 34000 Montpellier");
        resto3.notifyOrder(order3, livraison);

    }
}




