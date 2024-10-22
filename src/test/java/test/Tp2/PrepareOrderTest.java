package test.Tp2;

import Tp2.Dish;
import Tp2.Height;
import Tp2.Order;
import Tp2.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrepareOrderTest {

    private Restaurant restaurant;
    private Dish dish;
    private Order order;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("Chez Bob");
        dish = new Dish("Pasta", Height.S);
        order = new Order(restaurant, dish, 2, 20, "123 Main St");
    }

    @Test
    public void testPrepareOrder() {

        Assertions.assertNotNull(order);
        Assertions.assertEquals(restaurant, order.getResto());
        Assertions.assertEquals(dish, order.getDish());
        Assertions.assertEquals(2, order.getQuantity());
        Assertions.assertEquals(20, order.getPrice());
        Assertions.assertEquals("123 Main St", order.getAdresse());
    }
}
