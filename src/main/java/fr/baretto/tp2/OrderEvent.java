package fr.baretto.tp2;

import java.util.UUID;

public class OrderEvent implements Event {
    private final UUID eventId;
    private final Order order;

    public OrderEvent(Order order) {
        this.eventId = UUID.randomUUID();
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public UUID getEventId() {
        return eventId;
    }

    @Override
    public EventType getEventType() {
        return EventType.ORDER_PREPARED;
    }
}
