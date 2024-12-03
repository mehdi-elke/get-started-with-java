package fr.baretto.tp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    void testNotifyObservers() {
        Restaurant restaurant = new Restaurant("Le Gourmet");

        DeliveryPlateform platform = new DeliveryPlateform();

        restaurant.addObserver(platform);

        Dish dish = new Dish("Pizza", 10.0);

        // Créez un client pour ce test
        Customer customer = new Customer("Alice", "Dupont", "123 Rue Principale", "0612345678");

        // Passez le client comme argument
        Order order = restaurant.prepareOrder(dish, 2, 10.0, "123 Rue Principale", customer);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("Pizza", order.getDish().getName());
        Assertions.assertEquals(2, order.getQuantity());
        Assertions.assertEquals("123 Rue Principale", order.getAddress());
    }

    @Test
    void testAddRemoveObserver() {
        Restaurant restaurant = new Restaurant("Le Bistro");

        DeliveryPlateform platform = new DeliveryPlateform();

        restaurant.addObserver(platform);
        Assertions.assertTrue(restaurant.getObservers().contains(platform));

        restaurant.removeObserver(platform);
        Assertions.assertFalse(restaurant.getObservers().contains(platform));
    }
}
