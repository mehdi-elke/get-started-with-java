package fr.foodfast.tp1;

import fr.foodfast.tp1.delivery.DeliveryPlatform;
import fr.foodfast.tp1.delivery.DeliveryProcessingException;
import fr.foodfast.tp1.order.Order;
import fr.foodfast.tp1.order.OrderPreparationException;

public class Application {

    public static void main(String[] args) {
        DeliveryPlatform livraison = new DeliveryPlatform();
        ErrorManagementService errorService = new ErrorManagementService();

        Restaurant resto1 = livraison.subscribeRestaurant(new Restaurant("Chez l'ancien"));
        Restaurant resto2 = livraison.subscribeRestaurant(new Restaurant("Point Sandwich"));

        try {
            Order order1 = resto1.prepareOrder(1, "Chez l'ancien", new Dish("Pizza", Dish.Size.L), 3, 20, "3 rue de la paix, 75010 Paris");
            resto1.notifyOrder(order1, livraison);
        } catch (OrderPreparationException | DeliveryProcessingException e) {
            errorService.logError(e.getMessage());
        }

        try {
            Order order2 = resto2.prepareOrder(2, "Point Sandwich", new Dish("Tacos", Dish.Size.M), 1, 11, "55 boulevard de la république, 75004 Paris");
            resto2.notifyOrder(order2, livraison);
        } catch (OrderPreparationException | DeliveryProcessingException e) {
            errorService.logError(e.getMessage());
        }

        // Afficher les journaux
        Logger logger = Logger.getInstance();
        System.out.println("Journaux des événements :");
        logger.getLogs().forEach(System.out::println);
    }

}




