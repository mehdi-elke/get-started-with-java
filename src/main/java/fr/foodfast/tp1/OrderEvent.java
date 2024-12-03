package fr.foodfast.tp1;

import java.util.UUID;

public class OrderEvent implements Event {
    private final UUID id;
    private final Order order;

    public OrderEvent(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
    }

    public UUID getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public EventType getEventType() {
        return EventType.ORDER_PREPARED;
    }
}