package fr.baretto.tp3;

import java.util.Map;
import java.util.UUID;

public class OrderEvent implements Event{
    private UUID id;
    private Order order;;

    public OrderEvent(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
