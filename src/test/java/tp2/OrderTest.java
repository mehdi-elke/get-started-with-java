package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class OrderTest {

    @Test
    void testOrderCreation() {
        Restaurant restaurant = new Restaurant("McDo");
        Dish bigMac = new Dish("BigMac", Dish.Taille.S);
        Dish fries = new Dish("Fries", Dish.Taille.M);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(bigMac, 2);
        dishes.put(fries, 3);

        Order order = new Order(restaurant, dishes, 25.65, "123 Street");

        assertEquals(restaurant, order.getRestaurant());
        assertEquals(dishes, order.getDishes());
        assertEquals(25.65, order.getPrice());
        assertEquals("123 Street", order.getDeliveryLocation());
    }

    @Test
    void testOrderToString() {
        Restaurant restaurant = new Restaurant("McDo");
        Dish bigMac = new Dish("BigMac", Dish.Taille.S);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(bigMac, 2);

        Order order = new Order(restaurant, dishes, 15.99, "456 Avenue");
        String expected = "Order{restaurant=McDo, dishes={Dish{nom='BigMac', taille=S}=2}, price=15.99, deliveryLocation='456 Avenue'}";

        assertEquals(expected, order.toString());
    }
}
