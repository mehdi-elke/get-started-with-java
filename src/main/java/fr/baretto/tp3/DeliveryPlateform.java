package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DeliveryPlateform implements Subscriber {
    private List<Order> orders;
    private Map<String, Restaurant> restaurants;
    private EventBus eventBus;

    public DeliveryPlateform( EventBus eventBus) {
        this.orders = new ArrayList<>();
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(Event event) throws DeliveryProcessingException, InterruptedException {
        if(event instanceof OrderEvent){
            Order order = ((OrderEvent) event).getOrder();
            if(orders.contains(order)){
                System.out.println("Commande déjà passée");
                Logger logger = Logger.getInstance();
                logger.addLog("");
            }else{
                Double random = Math.random();
                if (random < 0.2) {
                    try {
                        throw new DeliveryProcessingException("Kiki(ma chatonnette) a mangé toute la commande CHEEEEEEH");
                    }catch (DeliveryProcessingException e){
                        System.out.println(e.getMessage());
                        ErrorManagementService.exceptions.add(e);
                    }
                }

                eventBus.handleEvent(EventType.DELIVERY, new DeliveryEvent((OrderEvent)event, DeliveryStatus.IN_DELIVERY));
                orders.add(order);
                Thread.sleep((int) Math.random()*(15 -2) + 2*1000);
                eventBus.handleEvent(EventType.DELIVERY, new DeliveryEvent((OrderEvent)event, DeliveryStatus.DELIVERED));
            }
        }

    }
}
