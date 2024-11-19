package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class DeliveryPlatformTest {

    @Test
    void testDelivery() {
        DeliveryPlatform platform = new DeliveryPlatform();
        Restaurant restaurant = new Restaurant("McDo");
        Dish bigMac = new Dish("BigMac", Dish.Taille.S);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(bigMac, 1);

        Order order = new Order(restaurant, dishes, 10.50, "1010 Drive");

        // Capture the system output for verification (using a library like System Lambda)
        platform.delivery(order);

        // Since the delivery method just prints, ensure no exceptions are thrown
        assertDoesNotThrow(() -> platform.delivery(order));
    }
}
