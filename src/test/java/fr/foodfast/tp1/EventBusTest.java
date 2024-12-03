package fr.foodfast.tp1;

import org.junit.jupiter.api.Test;

import static fr.foodfast.tp1.DeliveryEvent.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventBusTest {
    @Test
    void testEventBusHandlesMultipleEventTypes() {
        // Create an EventBus
        EventBus eventBus = new EventBus();

        // Subscriber for the delivery platform
        Subscriber deliveryPlatformSubscriber = event -> {
            if (event instanceof OrderEvent) {
                OrderEvent orderEvent = (OrderEvent) event;
                System.out.println("Delivery platform notified: Order prepared -> " + orderEvent.getOrder().getId());
            } else if (event instanceof DeliveryEvent) {
                DeliveryEvent deliveryEvent = (DeliveryEvent) event;
                System.out.println("Delivery platform notified: Delivery -> " +
                        deliveryEvent.getOrder().getId() + ", Status: " + deliveryEvent.getStatus());
            }
        };

        // Subscriber for a specific restaurant
        Subscriber restaurantSubscriber = event -> {
            if (event instanceof DeliveryEvent) {
                DeliveryEvent deliveryEvent = (DeliveryEvent) event;
                if ("Chez l'ancien".equals(deliveryEvent.getOrder().getLocation())) {
                    System.out.println("Restaurant notified: Order delivered -> " +
                            deliveryEvent.getOrder().getId() + ", Status: " + deliveryEvent.getStatus());
                }
            }
        };

        // Add subscribers to the EventBus
        eventBus.subscribe(deliveryPlatformSubscriber);
        eventBus.subscribe(restaurantSubscriber);

        // Create an order
        Order order = new Order(1, "Chez l'ancien", new Dish("Pizza", Dish.Size.L), 2, 30, "Paris");

        // Create events
        OrderEvent orderEvent = new OrderEvent(order);
        DeliveryEvent deliveryInProgress = new DeliveryEvent(order, IN_DELIVERY);
        DeliveryEvent deliveryCompleted = new DeliveryEvent(order, DELIVERED);

        // Notify subscribers
        System.out.println("\n== Notification: Order Prepared ==");
        eventBus.notifySubscribers(orderEvent);

        System.out.println("\n== Notification: Delivery In Progress ==");
        eventBus.notifyDeliveryEvent(deliveryInProgress);

        System.out.println("\n== Notification: Delivery Completed ==");
        eventBus.notifyDeliveryEvent(deliveryCompleted);

        // Verify subscribers are registered
        assertEquals(2, eventBus.getSubscribers().size());
    }
}
