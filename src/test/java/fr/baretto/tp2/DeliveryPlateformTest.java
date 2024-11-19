package fr.baretto.tp2;

import org.junit.jupiter.api.Test;

public class DeliveryPlateformTest {

    @Test
    public void testDeliverOrder() {
        Restaurant restaurant = new Restaurant("Le Gourmet");
        Dish dish = new Dish("Burger", 8.0);
        Order order = new Order(restaurant, dish, 3, 8.0, "456 Avenue de la Liberté");
        DeliveryPlateform platform = new DeliveryPlateform();

        platform.deliverOrder(order);
    }
}