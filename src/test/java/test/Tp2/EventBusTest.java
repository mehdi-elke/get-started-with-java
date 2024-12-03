package test.Tp2;

import Tp2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EventBusTest {
    private EventBus eventBus;
    private Subcriber subscriber;
    private Order order;

    @BeforeEach
    public void setUp() {
        eventBus = new EventBus();
        subscriber = mock(Subcriber.class);
        order = new Order(new Restaurant("Chez Bob"), new Dish("Pasta", Height.S), 2, 20, "123 Main St");
    }

    @Test
    public void testSubscribe() {
        eventBus.subscribe(EventType.DELIVERY, subscriber);
        assertEquals(1, eventBus.getSubscribersSize());
        assertTrue(eventBus.getSubscribers().containsKey(EventType.DELIVERY));
    }

    @Test
    public void testPublish() {
        eventBus.subscribe(EventType.DELIVERY, subscriber);
        eventBus.publish(new OrderEvent(EventType.DELIVERY));
        verify(subscriber, times(1)).handleEvent(any());
    }

    @Test
    public void testNoDuplicates() {
        eventBus.subscribe(EventType.DELIVERY, subscriber);
        eventBus.subscribe(EventType.DELIVERY, subscriber);
        assertEquals(1, eventBus.getSubscribersSize());
    }

    @Test
    public void testShouldNotifyDeliveryPlatform() {
        //TODO: Implement this test
    }

    @Test
    public void testRestaurantShouldPrintTheirInfo() {
        //TODO: Implement this test
    }
}
