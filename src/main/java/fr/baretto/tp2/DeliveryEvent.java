package fr.baretto.tp2;

import java.util.UUID;

public class DeliveryEvent implements Event {
    private final UUID eventId;
    private final Order order;
    private final DeliveryStatus status;
    private final UUID deliveryId;

    public DeliveryEvent(Order order, DeliveryStatus status) {
        this.eventId = UUID.randomUUID();
        this.order = order;
        this.status = status;
        this.deliveryId = UUID.randomUUID();
    }

    public Order getOrder() {
        return order;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public UUID getDeliveryId() {
        return deliveryId;
    }

    @Override
    public EventType getEventType() {
        return EventType.DELIVERY;
    }
}
