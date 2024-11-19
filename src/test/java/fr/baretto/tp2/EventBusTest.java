package fr.baretto.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
    public void testSubscribe() {
        eventBus.subscribe(subscriber1);
        eventBus.subscribe(subscriber2);

        assertEquals(2, eventBus.getSubscriberCount());
        assertTrue(eventBus.containsSubscriber(subscriber1));
        assertTrue(eventBus.containsSubscriber(subscriber2));
    }

    @Test
    public void testPublishEvent() {
        eventBus.subscribe(subscriber1);
        eventBus.subscribe(subscriber2);

        eventBus.publishEvent(order);

        verify(subscriber1, times(1)).handleEvent(order);
        verify(subscriber2, times(1)).handleEvent(order);
    }

    @Test
    public void testNoDuplicateSubscribers() {
        eventBus.subscribe(subscriber1);
        eventBus.subscribe(subscriber1); // Essai d'ajouter le même subscriber

        assertEquals(1, eventBus.getSubscriberCount());
    }
}