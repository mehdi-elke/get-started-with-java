package fr.foodfast.tp1;

import fr.foodfast.tp1.delivery.DeliveryPlatform;
import fr.foodfast.tp1.delivery.DeliveryProcessingException;
import fr.foodfast.tp1.order.Order;
import fr.foodfast.tp1.order.OrderPreparationException;

import java.util.Random;

public class Restaurant {

    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void notifyOrder(Order order, DeliveryPlatform livraison) throws DeliveryProcessingException {
        Random random = new Random();
        Logger logger = Logger.getInstance();
        NotificationService notificationService = new NotificationService();

        if (random.nextDouble() < 0.2) { // 20 % de probabilité d'échec
            throw new DeliveryProcessingException("Échec du traitement de la livraison pour la commande " + order.getId());
        }
        livraison.update(order);
        logger.logEvent("Commande livrée : " + order);

        notificationService.sendNotification("Votre commande " + order.getId() + " a été livrée à " + order.getPlace() + ".");
    }

    public Order prepareOrder(int id, String location, Dish dish, int quantity, int price, String place) throws OrderPreparationException {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Random random = new Random();
        Logger logger = Logger.getInstance();
        NotificationService notificationService = new NotificationService();

        if (random.nextDouble() < 0.2) { // 20 % de probabilité d'échec
            throw new OrderPreparationException("Échec de la préparation de la commande pour " + location);
        }
        Order order = new Order(id, location, dish, quantity, price, place);
        logger.logEvent("Commande reçue : " + order);

        notificationService.sendNotification("Votre commande " + order.getId() + " est en cours de préparation, " + order.getLocation() + ".");

        return order;
    }

}