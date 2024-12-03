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
        Assertions.assertEquals(Height.S, order.getDish().getSize());
        Assertions.assertEquals(2, order.getQuantity());
        Assertions.assertEquals(20, order.getPrice());
        Assertions.assertEquals("123 Main St", order.getAdresse());
    }

    @Test
    public void testPrepareOrderEquals() {
        Order order2 = new Order(restaurant, dish, 2, 20, "123 Main St");
        Assertions.assertTrue(order.equals(order2));
    }

    @Test
    public void testPrepareOrderAdressNotEquals() {
        Order order3 = new Order(restaurant, dish, 2, 20, "123 Main St 2");
        Assertions.assertFalse(order.equals(order3));
    }

    @Test
    public void testPrepareOrderDishNotEquals() {
        Dish dish2 = new Dish("Pasta", Height.M);
        Order order3 = new Order(restaurant, dish2, 2, 20, "123 Main St");
        Assertions.assertFalse(order.equals(order3));
    }

    @Test
    public void testPrepareOrderQuantityNotEquals() {
        Order order3 = new Order(restaurant, dish, 3, 20, "123 Main St");
        Assertions.assertFalse(order.equals(order3));
    }
}
