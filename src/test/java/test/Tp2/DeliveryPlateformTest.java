package test.Tp2;
import Tp2.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeliveryPlateformTest {

    private DeliveryPlateform deliveryPlateform;
    private Restaurant restaurant;
    private Dish dish;
    private Order order;

    @BeforeEach
    public void setUp() {
        deliveryPlateform = new DeliveryPlateform("UberEats");
        restaurant = new Restaurant("Chez Bob");
        dish = new Dish("Pasta", Height.S);
        order = new Order(restaurant, dish, 2, 20, "123 Main St");
    }

    @Test
    public void deliveryTestOrderNotNull() {
        Assertions.assertNotNull(order);
    }

    @Test
    public void deliverySuccessTest() {
        deliveryPlateform.update(order);
        Assertions.assertEquals("Delivery: Pasta From Chez Bob To 123 Main St", deliveryPlateform.getDeliveryOutput());
    }

}
