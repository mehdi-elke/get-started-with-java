package tp2;

import fr.tp2.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EventBusTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private EventBus eventBus;
    private Restaurant mcdo;
    private Restaurant subway;
    private DeliveryPlatform deliveryPlatform;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
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
    public void testPublishEvent() throws Exception {
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Order order = new Order(mcdo, (new ListDishes()).addDish(bigMac, 1).getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        mcdo.prepareOrder(order);
        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    public void testNoSubscriber() throws Exception {
        EventBus.subscribers.clear();
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Order order = new Order(mcdo, (new ListDishes()).addDish(bigMac, 1).getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        mcdo.prepareOrder(order);
        assertEquals("", outputStreamCaptor.toString().trim());
    }
}