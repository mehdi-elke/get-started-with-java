package fr.baretto.tp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RestaurantTest {

    @Test
    public void testNotifyObservers() {
        Restaurant restaurant = new Restaurant("Le Gourmet");

        DeliveryPlateform platform = new DeliveryPlateform();

        restaurant.addObserver(platform);

        Dish dish = new Dish("Pizza", 10.0);

        Order order = restaurant.prepareOrder(dish, 2, 10.0, "123 Rue Principale");

        Assertions.assertNotNull(order);
        Assertions.assertEquals("Pizza", order.getDish().getName());
        Assertions.assertEquals(2, order.getQuantity());
        Assertions.assertEquals("123 Rue Principale", order.getAddress());
    }

    @Test
    public void testAddRemoveObserver() {
        Restaurant restaurant = new Restaurant("Le Bistro");

        DeliveryPlateform platform = new DeliveryPlateform();

        restaurant.addObserver(platform);
        Assertions.assertTrue(restaurant.getObservers().contains(platform));

        restaurant.removeObserver(platform);
        Assertions.assertFalse(restaurant.getObservers().contains(platform));
    }
}
