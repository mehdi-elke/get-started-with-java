package Tp2;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.Flow;

public class Restaurant implements Subcriber{

    private final String name;
    private Watcher deliveryPlateform;
    public Restaurant(String name) {this.name = name;}
    public DeliveryPlateform delplat;
  ;
    public void addDeliveryPlateform(DeliveryPlateform deliveryPlateform) {
        delplat= deliveryPlateform;
    }
    public Order prepareOrder(Dish dish, int quantity, int price, String address, UUID id) {

        Order nOrder =  new Order(this, dish, quantity, price, address);
        DeliveryEvent deliveryEvent = new DeliveryEvent(EventType.DELIVERY, nOrder);

        deliveryEvent.setPayload(delplat);
        EventBus.getInstance().publish(deliveryEvent);
        Logger.getInstance().logEvent("Order prepared: " + dish.getName() + " From " + this.getName() + " To " + address);

        return nOrder;
    }
    public void setWatcher(Watcher watcher) {
        this.deliveryPlateform = watcher;
    }
    public String getName() {return name;}

    public void handleEvent(Event order) {
        if (order instanceof OrderEvent) {
            OrderEvent orderEvent = (OrderEvent) order;
            Order order1 = orderEvent.getPayload();
            if (order1.getResto().equals(this)) {
                this.prepareOrder(order1.getDish(), order1.getQuantity(), order1.getPrice(), order1.getAdresse(), orderEvent.getId());
            }
            else {
                return;
            }
        }
    }
    public void sub(){
        EventBus.getInstance().subscribe(EventType.ORDER_PREPARED, this);
    }
}
