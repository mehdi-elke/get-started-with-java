package fr.baretto.tp2;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Le Wagon");
        Restaurant restaurant2 = new Restaurant("O'Tacos");

        DeliveryPlateform deliveryPlateform = new DeliveryPlateform();

        restaurant1.addObserver(deliveryPlateform);
        restaurant2.addObserver(deliveryPlateform);

        // Créez des clients
        Customer customer1 = new Customer("Alice", "Dupont", "28 rue d'inkermann", "0612345678");
        Customer customer2 = new Customer("Bob", "Martin", "81 rue d'inkermann, Roubaix", "0698765432");
        Customer customer3 = new Customer("Charlie", "Durand", "43 rue du jardin des plantes", "0789456123");

        // Ajoutez le client comme dernier argument
        Order order1 = restaurant1.prepareOrder(new Dish("Tacos", 8.0), 4, 11.0, "28 rue d'inkermann", customer1);
        Order order2 = restaurant1.prepareOrder(new Dish("Pizza", 8.0), 1, 15.0, "81 rue d'inkermann, Roubaix", customer2);
        Order order3 = restaurant2.prepareOrder(new Dish("Burger", 5.5), 10, 5.5, "43 rue du jardin des plantes", customer3);

        deliveryPlateform.subscribe(restaurant1);
        deliveryPlateform.subscribe(restaurant2);
    }
}
