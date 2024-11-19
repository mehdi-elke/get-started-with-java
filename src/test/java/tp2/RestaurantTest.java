package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class RestaurantTest {

    @Test
    void testPrepareOrder() {
        Restaurant restaurant = new Restaurant("McDo");
        Dish bigMac = new Dish("BigMac", Dish.Taille.S);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(bigMac, 3);

        Order order = restaurant.prepareOrder(dishes, 30.00, "789 Boulevard");

        assertEquals("McDo", order.getRestaurant().getName());
        assertEquals(dishes, order.getDishes());
        assertEquals(30.00, order.getPrice());
        assertEquals("789 Boulevard", order.getDeliveryLocation());
    }
}
