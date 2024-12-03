package fr.baretto.tp2;

import java.util.UUID;

public class DeliveryEvent implements Event {
    private final UUID eventId;
    private final Order order;
    private final DeliveryStatus status;
    private final UUID deliveryId;
    private final NotificationService notificationService;

    public DeliveryEvent(Order order, DeliveryStatus status, NotificationService notificationService) {
        this.eventId = UUID.randomUUID();
        this.order = order;
        this.status = status;
        this.deliveryId = UUID.randomUUID();
        this.notificationService = notificationService;
        Logger.getInstance().log("Nouvel événement de type " + getEventType() + " : " + eventId + " - Commande de " + order.getDish().getName() + " pour " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        sendDeliveryNotification();
    }

    private void sendDeliveryNotification() {
        String message = "Bonjour " + order.getCustomer().getFirstName() + ", votre commande de " +
                order.getDish().getName() + " est maintenant " + status.toString().toLowerCase() + ".";
        notificationService.sendNotification(message);
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
