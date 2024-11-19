package fr.baretto.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class EventBusTest {
    private EventBus eventBus;
    private Subscriber subscriber1;
    private Subscriber subscriber2;
    private Order order;

    @BeforeEach
    public void setup() {
        eventBus = new EventBus();
        subscriber1 = mock(Subscriber.class);
        subscriber2 = mock(Subscriber.class);
        order = new Order(new Restaurant("Le Gourmet"), new Dish("Pizza", 12.0), 2, 12.0, "123 Main St");
    }

    @Test
    public void testOrderPreparedEvent() {
        eventBus.subscribe(subscriber1);
        Event orderEvent = new OrderEvent(order);

        eventBus.publishEvent(orderEvent);

        verify(subscriber1, times(1)).handleEvent(orderEvent);
    }

    @Test
    public void testDeliveryEvent() {
        eventBus.subscribe(subscriber2);
        Event deliveryEvent = new DeliveryEvent(order, DeliveryStatus.IN_DELIVERY);

        eventBus.publishEvent(deliveryEvent);

        verify(subscriber2, times(1)).handleEvent(deliveryEvent);
    }
}
