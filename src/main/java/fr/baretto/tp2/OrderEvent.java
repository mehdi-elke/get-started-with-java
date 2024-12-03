package fr.baretto.tp2;

import java.util.UUID;

public class OrderEvent implements Event {
    private final UUID eventId;
    private final Order order;
    private final NotificationService notificationService;

    public OrderEvent(Order order, NotificationService notificationService) {
        this.eventId = UUID.randomUUID();
        this.order = order;
        this.notificationService = notificationService;
        sendOrderPreparedNotification();
    }

    private void sendOrderPreparedNotification() {
        String message = "Bonjour " + order.getCustomer().getFirstName() + ", votre commande de " +
                order.getDish().getName() + " est en cours de préparation.";
        notificationService.sendNotification(message);
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
