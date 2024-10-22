package test.Tp2;

import Tp2.Dish;
import Tp2.Height;
import Tp2.Order;
import Tp2.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrepareOrderTest {

    @Test
    public void testPrepareOrder() {
        Restaurant resto = new Restaurant("Chez Bob");
        Dish dish = new Dish("Pasta", Height.S);
        int quantity = 2;
        int price = 20;
        String address = "123 Main St";

        Order order = resto.prepareOrder(dish, quantity, price, address);

        Assertions.assertNotNull(order);
        Assertions.assertEquals(resto, order.getResto());
        Assertions.assertEquals(dish, order.getDish());
        Assertions.assertEquals(quantity, order.getQuantity());
        Assertions.assertEquals(price, order.getPrice());
        Assertions.assertEquals(address, order.getAdresse());
    }
}
