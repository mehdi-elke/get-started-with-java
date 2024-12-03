package fr.baretto.tp2;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void testOrderEventNotification() {
        NotificationService notificationService = mock(NotificationService.class);
        Customer customer = new Customer("Alice", "Dupont", "123 Rue Principale", "0612345678");
        Dish dish = new Dish("Pizza", 12.0);
        Order order = new Order(new Restaurant("Le Gourmet"), dish, 2, 12.0, "123 Rue Principale", customer);

        new OrderEvent(order, notificationService);

        verify(notificationService).sendNotification(contains("Bonjour Alice, votre commande de Pizza est en cours de préparation."));
    }

    @Test
    void testDeliveryEventNotification() {
        NotificationService notificationService = mock(NotificationService.class);
        Customer customer = new Customer("Bob", "Martin", "456 Rue Secondaire", "0698765432");
        Dish dish = new Dish("Burger", 8.0);
        Order order = new Order(new Restaurant("Le Gourmet"), dish, 1, 8.0, "456 Rue Secondaire", customer);

        new DeliveryEvent(order, DeliveryStatus.DELIVERED, notificationService);

        verify(notificationService).sendNotification(contains("Bonjour Bob, votre commande de Burger est maintenant delivered."));
    }
}
