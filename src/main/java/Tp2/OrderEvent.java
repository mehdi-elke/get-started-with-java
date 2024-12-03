package Tp2;

import java.rmi.server.UID;
import java.util.UUID;

public class OrderEvent implements Event{
    private EventType type;
    private Order order;
    private UUID id;
    public OrderEvent(EventType type){
        this.id = UUID.randomUUID();
        this.type = type;

    }

    @Override
    public void setPayload(Object o) {
        this.order = (Order) o;
    }

    public Order getPayload(){
        return this.order;
    }
    public UUID getId(){
        return this.id;
    }
    public EventType getType(){
        return this.type;
    }
}
