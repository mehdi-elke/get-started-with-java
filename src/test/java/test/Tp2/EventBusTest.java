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
        eventBus.subscribe(subscriber);
        assertEquals(1, eventBus.getSubscribersSize());
        assertTrue(eventBus.isSubscribed(subscriber));
    }

    @Test
    public void testPublish() {
        eventBus.subscribe(subscriber);
        eventBus.publish(order);
        verify(subscriber, times(1)).handleEvent(order);
    }

    @Test
    public void testNoDuplicates() {
        eventBus.subscribe(subscriber);
        eventBus.subscribe(subscriber);
        assertEquals(1, eventBus.getSubscribersSize());
    }
}
