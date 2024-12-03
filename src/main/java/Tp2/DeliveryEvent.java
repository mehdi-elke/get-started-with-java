package Tp2;

import java.util.UUID;

public class DeliveryEvent implements Event{
    private EventType type;
    public Order ord;
    private DeliveryPlateform deliveryPlateform;
    public DeliveryEvent(EventType type, Order orderUUID){
        this.type = type;
        this.ord = orderUUID;
    }
    public DeliveryPlateform getPayload(){
        return this.deliveryPlateform;
    }

    @Override
    public void setPayload(Object o) {
        this.deliveryPlateform = (DeliveryPlateform) o;
    }

    public EventType getType(){
        return this.type;
    }
    public UUID getId(){
        return null;
    }
}
