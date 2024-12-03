package fr.baretto.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EventBusTest {
    private EventBus eventBus;
    private Subscriber subscriber1;
    private Subscriber subscriber2;
    private Order order;
    private NotificationService notificationService;

    @BeforeEach
    void setup() {
        eventBus = new EventBus();
        subscriber1 = mock(Subscriber.class);
        subscriber2 = mock(Subscriber.class);
        notificationService = mock(NotificationService.class); // Mock de NotificationService
        order = new Order(new Restaurant("Le Gourmet"), new Dish("Pizza", 12.0), 2, 12.0, "123 Main St",
                new Customer("John", "Doe", "123 Main St", "0123456789"));
    }

    @Test
    void testOrderPreparedEvent() {
        eventBus.subscribe(subscriber1);
        Event orderEvent = new OrderEvent(order, notificationService);

        eventBus.publishEvent(orderEvent);

        verify(subscriber1, times(1)).handleEvent(orderEvent);
        verify(notificationService).sendNotification(contains("Bonjour John, votre commande de Pizza est en cours de préparation."));
    }

    @Test
    void testDeliveryEvent() {
        eventBus.subscribe(subscriber2);
        Event deliveryEvent = new DeliveryEvent(order, DeliveryStatus.IN_DELIVERY, notificationService);

        eventBus.publishEvent(deliveryEvent);

        verify(subscriber2, times(1)).handleEvent(deliveryEvent);
        verify(notificationService).sendNotification(contains("Bonjour John, votre commande de Pizza est maintenant in delivery."));
    }
}
