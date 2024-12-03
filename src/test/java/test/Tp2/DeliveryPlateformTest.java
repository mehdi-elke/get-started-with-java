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
    public void deliveryTestPlateformNotNull() {
        Assertions.assertNotNull(deliveryPlateform);
    }

    @Test
    public void getPlateformTest() {
        Assertions.assertEquals("UberEats", deliveryPlateform.getPlateform());
    }

    @Test
    public void deliveryTestOrderNotNull() {
        Assertions.assertNotNull(order);
    }


    @Test
    public void deliverySuccessTest() throws DeliveryProcessingException {
        deliveryPlateform.delivery(order);
        Assertions.assertEquals("Delivery: Pasta From Chez Bob To 123 Main St", deliveryPlateform.getDeliveryOutput());
    }

    @Test
    public void updateTestOrderAlreadyExists() throws DeliveryProcessingException {
        deliveryPlateform.delivery(order);
        deliveryPlateform.delivery(order);
        Assertions.assertEquals(1, deliveryPlateform.getSetOrderSize());
    }

    @Test
    public void deliveryMethodTest() throws DeliveryProcessingException {
        deliveryPlateform.delivery(order);
    }


}
