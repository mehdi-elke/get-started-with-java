package fr.foodfast.tp1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEventBusWithMultipleEventTypes {
    @Test
    void testEventBusHandlesMultipleEventTypes() {
        // Création de l'EventBus
        EventBus eventBus = new EventBus();

        // Création d'un abonné pour la plateforme de livraison
        Subscriber deliveryPlatformSubscriber = event -> {
            if (event instanceof OrderEvent) {
                OrderEvent orderEvent = (OrderEvent) event;
                System.out.println("Plateforme de livraison notifiée : Commande préparée -> " + orderEvent.getOrder().getId());
            } else if (event instanceof DeliveryEvent) {
                DeliveryEvent deliveryEvent = (DeliveryEvent) event;
                System.out.println("Plateforme de livraison notifiée : Livraison -> " +
                        deliveryEvent.getOrder().getId() + ", Statut: " + deliveryEvent.getStatus());
            }
        };

        // Création d'un abonné pour un restaurant spécifique
        Subscriber restaurantSubscriber = event -> {
            if (event instanceof DeliveryEvent) {
                DeliveryEvent deliveryEvent = (DeliveryEvent) event;
                if ("Chez l'ancien".equals(deliveryEvent.getOrder().getLocation())) {
                    System.out.println("Restaurant notifié : Commande livrée -> " +
                            deliveryEvent.getOrder().getId() + ", Statut: " + deliveryEvent.getStatus());
                }
            }
        };

        // Ajout des abonnés à l'EventBus
        eventBus.subscribe(deliveryPlatformSubscriber);
        eventBus.subscribe(restaurantSubscriber);

        // Création d'une commande
        Order order = new Order(1, "Chez l'ancien", new Dish("Pizza", Dish.Size.L), 2, 30, "Paris");

        // Création d'événements
        OrderEvent orderEvent = new OrderEvent(order);
        DeliveryEvent deliveryEventInProgress = new DeliveryEvent(order, DeliveryEvent.Status.IN_DELIVERY);
        DeliveryEvent deliveryEventCompleted = new DeliveryEvent(order, DeliveryEvent.Status.DELIVERED);

        // Notification des abonnés
        System.out.println("\n== Notification : Commande préparée ==");
        eventBus.notifySubscribers(orderEvent);

        System.out.println("\n== Notification : Livraison en cours ==");
        eventBus.notifySubscribers(deliveryEventInProgress);

        System.out.println("\n== Notification : Livraison terminée ==");
        eventBus.notifySubscribers(deliveryEventCompleted);

        // Vérification que les abonnés sont enregistrés
        assertEquals(2, eventBus.getSubscribers().size());
    }
}
