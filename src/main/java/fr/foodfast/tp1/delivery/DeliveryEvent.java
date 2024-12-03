package fr.foodfast.tp1.delivery;

import fr.foodfast.tp1.event.Event;
import fr.foodfast.tp1.event.EventType;
import fr.foodfast.tp1.order.Order;

import java.util.UUID;

public class DeliveryEvent implements Event {
    public enum Status {
        IN_DELIVERY,
        DELIVERED
    }

    private final UUID id;
    private final Order order;
    private final Status status;
    private final UUID deliveryNumber;

    public DeliveryEvent(Order order, Status status) {
        this.id = UUID.randomUUID();
        this.order = order;
        this.status = status;
        this.deliveryNumber = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Status getStatus() {
        return status;
    }

    public UUID getDeliveryNumber() {
        return deliveryNumber;
    }

    @Override
    public EventType getEventType() {
        return EventType.DELIVERY;
    }
}