package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeliveryPlateform implements Subscriber {
    private List<Order> orders;
    private EventBus eventBus;

    public DeliveryPlateform( EventBus eventBus) {
        this.orders = new ArrayList<>();
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(Event event) throws InterruptedException {
        if(event instanceof OrderEvent){
            Order order = ((OrderEvent) event).getOrder();
            if(orders.contains(order)){
                System.out.println("Commande déjà passée");
            }else{
                eventBus.handleEvent(EventType.DELIVERY, new DeliveryEvent((OrderEvent)event, DeliveryStatus.DELIVERED));
                orders.add(order);
            }
        }

    }
}
