package tp2;

import fr.tp2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventBusTest {

    private EventBus eventBus;
    private Restaurant mcdo;
    private Restaurant subway;
    private DeliveryPlatform deliveryPlatform;

    @BeforeEach
    public void setUp() {
        EventBus.subscribers.clear();
        mcdo = new Restaurant("McDonald's");
        subway = new Restaurant("Subway");
        deliveryPlatform = new DeliveryPlatform();

        EventBus.subscribe(deliveryPlatform);
    }

    @Test
    public void testSubscribe() {
        assertTrue(EventBus.subscribers.contains(deliveryPlatform));
    }

    @Test
    public void testPublishEvent() throws InterruptedException {
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Order order = new Order(mcdo, (new ListDishes()).addDish(bigMac, 1).getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        mcdo.prepareOrder(order);

        Thread.sleep(5000);

        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    public void testNoSubscriber() throws InterruptedException {
        EventBus.subscribers.clear();
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Order order = new Order(mcdo, (new ListDishes()).addDish(bigMac, 1).getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        mcdo.prepareOrder(order);

        Thread.sleep(5000);
        assertEquals(OrderStatus.READY_FOR_DELIVERY, order.getStatus());
    }
}