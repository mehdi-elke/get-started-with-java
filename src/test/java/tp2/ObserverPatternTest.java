package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class ObserverPatternTest {

    @Test
    void testObserverReceivesNotification() {
        DeliveryPlatform platform = new DeliveryPlatform();
        Restaurant restaurant = new Restaurant("McDo");


        restaurant.addObserver(platform);

        Dish dish = new Dish("BigMac", Dish.Taille.M);
        Map<Dish, Integer> dishes = Map.of(dish, 2);


        Order order = restaurant.prepareOrder(dishes, 15.50, "123 Main St");

        assertNotNull(order);
        assertEquals("McDo", order.getRestaurant().getName());
        assertEquals(15.50, order.getPrice());
        assertEquals("123 Main St", order.getDeliveryLocation());
    }
}
