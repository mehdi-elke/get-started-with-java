package tp2;
import java.util.UUID;

public class DeliveryEvent implements Event {
    private UUID id;
    private Order order;
    private String status;
    private UUID deliveryId;

    public DeliveryEvent(Order order, String status) {
        this.id = UUID.randomUUID();
        this.order = order;
        this.status = status;
        this.deliveryId = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public EventType getType() {
        return EventType.DELIVERY;
    }

    @Override
    public String toString() {
        return "DeliveryEvent{" +
                "id=" + id +
                ", order=" + order +
                ", status='" + status + '\'' +
                ", deliveryId=" + deliveryId +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(UUID deliveryId) {
        this.deliveryId = deliveryId;
    }
}