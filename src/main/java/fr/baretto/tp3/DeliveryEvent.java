package fr.baretto.tp3;

import java.util.UUID;

public class DeliveryEvent implements Event {
    private UUID orderNumber;
    private Order order;
    private DeliveryStatus deliveryStatus;

    public DeliveryEvent(OrderEvent orderEvent, DeliveryStatus deliveryStatus) {
        this.order = orderEvent.getOrder();
        this.orderNumber = UUID.randomUUID();
        this.deliveryStatus = deliveryStatus;
    }

    public Order getOrder() {
        return order;
    }

    public UUID getOrderNumber() {
        return orderNumber;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
