package fr.baretto.tp3;

import java.util.Map;
import java.util.UUID;

public class OrderEvent {
    private UUID id;
    private Order order;;

    public OrderEvent(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
    }
}
