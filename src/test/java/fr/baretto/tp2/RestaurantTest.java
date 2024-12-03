package fr.baretto.tp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    void testNotifyObservers() throws DeliveryProcessingException, OrderPreparationException {
        Restaurant restaurant = new Restaurant("Le Gourmet");

        DeliveryPlateform platform = new DeliveryPlateform();
        restaurant.addObserver(platform);

        Dish dish = new Dish("Pizza", 10.0);
        Customer customer = new Customer("Alice", "Dupont", "123 Rue Principale", "0612345678");

        try {
            Order order = restaurant.prepareOrder(dish, 2, 10.0, "123 Rue Principale", customer);
            Assertions.assertNotNull(order, "La commande ne doit pas être null.");
            Assertions.assertEquals("Pizza", order.getDish().getName());
            Assertions.assertEquals(2, order.getQuantity());
            Assertions.assertEquals("123 Rue Principale", order.getAddress());
        } catch (OrderPreparationException e) {
            Assertions.fail("Une exception inattendue a été levée : " + e.getMessage());
        }
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
