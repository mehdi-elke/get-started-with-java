package tp2;

import java.util.UUID;

public class OrderEvent implements Event {
    private UUID id;
    private Order order;

    public OrderEvent(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public EventType getType() {
        return EventType.ORDER_PREPARED;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "id=" + id +
                ", order=" + order +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}