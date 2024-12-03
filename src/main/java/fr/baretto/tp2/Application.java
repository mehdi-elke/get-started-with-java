package fr.baretto.tp2;

public class Application {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Cas 1 : Création des restaurants
        System.out.println("==== CAS 1 : Création des restaurants ====");
        Restaurant restaurant1 = new Restaurant("Le Wagon");
        Restaurant restaurant2 = new Restaurant("O'Tacos");
        logger.log("Restaurants créés : " + restaurant1.getName() + ", " + restaurant2.getName());

        // Cas 2 : Inscription à la plateforme de livraison
        System.out.println("\n==== CAS 2 : Inscription des restaurants à la plateforme ====");
        DeliveryPlateform deliveryPlateform = new DeliveryPlateform();
        restaurant1.addObserver(deliveryPlateform);
        restaurant2.addObserver(deliveryPlateform);
        logger.log("Restaurants inscrits à la plateforme de livraison.");

        // Cas 3 : Création des clients
        System.out.println("\n==== CAS 3 : Création des clients ====");
        Customer customer1 = new Customer("Alice", "Dupont", "28 rue d'inkermann", "0612345678");
        Customer customer2 = new Customer("Bob", "Martin", "81 rue d'inkermann, Roubaix", "0698765432");
        Customer customer3 = new Customer("Charlie", "Durand", "43 rue du jardin des plantes", "0789456123");
        logger.log("Clients créés : " + customer1.getFirstName() + ", " + customer2.getFirstName() + ", " + customer3.getFirstName());

        // Cas 4 : Préparation des commandes
        System.out.println("\n==== CAS 4 : Préparation des commandes ====");
        try {
            Order order1 = restaurant1.prepareOrder(new Dish("Tacos", 8.0), 4, 11.0, "28 rue d'inkermann", customer1);
            logger.log("Commande préparée pour " + customer1.getFirstName() + " : " + order1.getDish().getName());

            Order order2 = restaurant1.prepareOrder(new Dish("Pizza", 8.0), 1, 15.0, "81 rue d'inkermann, Roubaix", customer2);
            logger.log("Commande préparée pour " + customer2.getFirstName() + " : " + order2.getDish().getName());

            Order order3 = restaurant2.prepareOrder(new Dish("Burger", 5.5), 10, 5.5, "43 rue du jardin des plantes", customer3);
            logger.log("Commande préparée pour " + customer3.getFirstName() + " : " + order3.getDish().getName());
        } catch (OrderPreparationException e) {
            logger.log("Erreur lors de la préparation d'une commande : " + e.getMessage());
        } catch (DeliveryProcessingException e) {
            throw new RuntimeException(e);
        }

        // Cas 5 : Livraison des commandes
        System.out.println("\n==== CAS 5 : Livraison des commandes ====");
        try {
            deliveryPlateform.deliverOrder(new Order(restaurant1, new Dish("Tacos", 8.0), 4, 11.0, "28 rue d'inkermann", customer1));
            logger.log("Commande livrée pour " + customer1.getFirstName());

            deliveryPlateform.deliverOrder(new Order(restaurant1, new Dish("Pizza", 8.0), 1, 15.0, "81 rue d'inkermann, Roubaix", customer2));
            logger.log("Commande livrée pour " + customer2.getFirstName());

            deliveryPlateform.deliverOrder(new Order(restaurant2, new Dish("Burger", 5.5), 10, 5.5, "43 rue du jardin des plantes", customer3));
            logger.log("Commande livrée pour " + customer3.getFirstName());
        } catch (DeliveryProcessingException e) {
            logger.log("Erreur lors de la livraison d'une commande : " + e.getMessage());
        }

        // Affichage des logs
        System.out.println("\n==== CAS 6 : Journal des événements ====");
        logger.getLogs();
    }
}
