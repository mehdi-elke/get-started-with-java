package fr.baretto.tp3;

import java.util.UUID;

public class DeliveryEvent implements Event {
    private Order order;
    private UUID orderNumber;
    private DeliveryStatus deliveryStatus;

    public DeliveryEvent(OrderEvent orderEvent, DeliveryStatus deliveryStatus) {
        this.order = orderEvent.getOrder();
        this.orderNumber = UUID.randomUUID();
        this.deliveryStatus = deliveryStatus;
    }
}
