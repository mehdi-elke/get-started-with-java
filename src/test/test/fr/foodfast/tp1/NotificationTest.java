package fr.foodfast.tp1;

import fr.foodfast.tp1.delivery.DeliveryPlatform;
import fr.foodfast.tp1.delivery.DeliveryProcessingException;
import fr.foodfast.tp1.order.Order;
import fr.foodfast.tp1.order.OrderPreparationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {

    DeliveryPlatform livraison = new DeliveryPlatform();
    Restaurant resto1 = livraison.subscribeRestaurant(new Restaurant("Chez l'ancien"));
    Order order1 = resto1.prepareOrder(1, resto1.getName(), new Dish("Pizza", Dish.Size.L), 3, 20, "3 Rue de la Paix, Lille");
    Customer customer = new Customer("John", "Doe", "123 Rue Nationale, Lille", "555-1234");

    public NotificationTest() throws OrderPreparationException {
    }

    @Test
    public void testOrderPreparationNotification() {
        assertNotNull(order1, "La commande ne doit pas être nulle");
        assertEquals(1, order1.getId(), "L'ID de la commande doit être 1");
        assertEquals("Pizza", order1.getDish().getName(), "Le nom du plat doit être Pizza");
        assertEquals(Dish.Size.L, order1.getDish().getSize(), "La taille du plat doit être L");
        assertEquals(3, order1.getQuantity(), "La quantité doit être 3");
        assertEquals(60, order1.getPrice(), "Le prix doit être 20");
        assertEquals("3 Rue de la Paix, Lille", order1.getAddress(), "L'adresse doit être '3 Rue de la Paix, Lille'");
    }

    @Test
    public void testOrderDeliveryNotification() throws DeliveryProcessingException {
        resto1.notifyOrder(order1, livraison);
        assertNotNull(order1, "La commande ne doit pas être nulle");
        assertEquals(1, order1.getId(), "L'ID de la commande doit être 2");
        assertEquals("Pizza", order1.getDish().getName(), "Le nom du plat doit être Pizza");
        assertEquals(Dish.Size.L, order1.getDish().getSize(), "La taille du plat doit être L");
        assertEquals(3, order1.getQuantity(), "La quantité doit être 3");
        assertEquals(60, order1.getPrice(), "Le prix doit être 20");
        assertEquals("3 Rue de la Paix, Lille", order1.getAddress(), "L'adresse doit être '3 Rue de la Paix, Lille'");
    }
}