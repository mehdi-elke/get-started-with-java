package fr.baretto.tp3;

import java.util.UUID;

public class DeliveryEvent {
    private Order order;
    private UUID orderNumber;
    private DeliveryStatus deliveryStatus;

    public DeliveryEvent(Order order, OrderEvent orderEvent, DeliveryStatus deliveryStatus) {
        this.order = order;
        this.orderNumber = orderEvent.getId();
        this.deliveryStatus = deliveryStatus;
    }
}
