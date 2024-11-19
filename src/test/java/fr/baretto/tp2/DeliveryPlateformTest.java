package fr.baretto.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryPlateformTest {

    private DeliveryPlateform deliveryPlatform;
    private Restaurant restaurant;

    @BeforeEach
    public void setup() {
        deliveryPlatform = new DeliveryPlateform();
        restaurant = new Restaurant("Testaurant");
        restaurant.addObserver(deliveryPlatform);
    }

    @Test
    public void testDeliverOrder() {
        Restaurant restaurant = new Restaurant("Le Gourmet");
        Dish dish = new Dish("Burger", 8.0);
        Order order = new Order(restaurant, dish, 3, 8.0, "456 Avenue de la Liberté");
        DeliveryPlateform platform = new DeliveryPlateform();

        platform.deliverOrder(order);
    }

    @Test
    public void testUniqueOrder() {
        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix");

        deliveryPlatform.update(order1);
        assertTrue(deliveryPlatform.containsOrder(order1));
        assertEquals(1, deliveryPlatform.getOrderCount());
    }

    @Test
    public void testDuplicateOrder() {
        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix");
        Order duplicateOrder = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix");

        deliveryPlatform.update(order1);

        deliveryPlatform.update(duplicateOrder);

        assertEquals(1, deliveryPlatform.getOrderCount());
        assertTrue(deliveryPlatform.containsOrder(order1));
    }

    @Test
    public void testDifferentOrder() {
        Order order1 = new Order(restaurant, new Dish("Pizza", 8.0), 2, 11.0, "10 rue de la paix");
        Order order2 = new Order(restaurant, new Dish("Tacos", 5.0), 1, 15.0, "20 rue de la liberté");

        deliveryPlatform.update(order1);
        deliveryPlatform.update(order2);

        assertEquals(2, deliveryPlatform.getOrderCount());
        assertTrue(deliveryPlatform.containsOrder(order1));
        assertTrue(deliveryPlatform.containsOrder(order2));
    }
}