package fr.baretto.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryPlateformTest {

    private DeliveryPlateform deliveryPlatform;
    private Restaurant restaurant;

    @BeforeEach
    public void setup() {
        deliveryPlatform = new DeliveryPlateform();
        restaurant = new Restaurant("Testaurant");
        restaurant.addObserver(deliveryPlatform);
    }

    @Test
    void testDeliverOrder() throws DeliveryProcessingException {
        Restaurant testRestaurant = new Restaurant("Le Gourmet");
        Dish dish = new Dish("Burger", 8.0);

        // Créez un client pour ce test
        Customer customer = new Customer("Alice", "Dupont", "456 Avenue de la Liberté", "0612345678");

        // Incluez le client dans le constructeur
        Order order = new Order(testRestaurant, dish, 3, 8.0, "456 Avenue de la Liberté", customer);
        DeliveryPlateform platform = new DeliveryPlateform();

        platform.deliverOrder(order);

        assertTrue(platform.containsOrder(order));
    }

    @Test
    void testUniqueOrder() throws DeliveryProcessingException {
        Customer customer = new Customer("Bob", "Martin", "10 rue de la paix", "0623456789");
        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix", customer);

        deliveryPlatform.update(order1);
        assertTrue(deliveryPlatform.containsOrder(order1));
        assertEquals(1, deliveryPlatform.getOrderCount());
    }

    @Test
    void testDuplicateOrder() throws DeliveryProcessingException {
        Customer customer = new Customer("Charlie", "Durand", "10 rue de la paix", "0634567890");
        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix", customer);
        Order duplicateOrder = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix", customer);

        deliveryPlatform.update(order1);
        deliveryPlatform.update(duplicateOrder);

        assertEquals(1, deliveryPlatform.getOrderCount());
        assertTrue(deliveryPlatform.containsOrder(order1));
    }

    @Test
    void testDifferentOrder() throws DeliveryProcessingException {
        Customer customer1 = new Customer("Diane", "Moreau", "10 rue de la paix", "0645678901");
        Customer customer2 = new Customer("Eve", "Blanc", "20 rue de la liberté", "0656789012");

        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix", customer1);
        Order order2 = new Order(restaurant, new Dish("Tacos", 5.0), 1, 15.0, "20 rue de la liberté", customer2);

        deliveryPlatform.update(order1);
        deliveryPlatform.update(order2);

        assertEquals(2, deliveryPlatform.getOrderCount());
        assertTrue(deliveryPlatform.containsOrder(order1));
        assertTrue(deliveryPlatform.containsOrder(order2));
    }
}