package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Restaurant implements Subscriber {
    private String name;
    private EventBus eventBus;

    public Restaurant(String name, EventBus eventBus) {
        this.name = name;
        this.eventBus = eventBus;
    }

    public String getName() {
        return name;
    }

    public Order prepareOrder(List<Dish> dishes, double price, String deliveryPlace) throws InterruptedException {
        Thread.sleep(new Random().nextInt(3000));
        Map<Dish, Integer> dishesMap = new HashMap<>();
        for(Dish dish : dishes){
            dishesMap.merge(dish, 1, Integer::sum);
        }
        Order order = new Order(this, dishesMap, price, deliveryPlace);
        OrderEvent orderEvent = new OrderEvent(order);
        this.eventBus.handleEvent(EventType.ORDER_PREPARED, orderEvent);
        return order;
    }


    @Override
    public void handleEvent(Event event) throws InterruptedException {
        if(event instanceof DeliveryEvent){
            DeliveryEvent deliveryEvent = ((DeliveryEvent) event);
            System.out.println("Livraisons de la commande à " + deliveryEvent.getOrder().getDeliveryPlace() + "...");
            var random = Math.random()*(15 -2) + 2*1000;
            Thread.sleep((int)random);
            deliveryEvent.setDeliveryStatus(DeliveryStatus.DELIVERED);
            System.out.println("Commande livrée, vous devez payer " + deliveryEvent.getOrder().getPrice() + " sivouplé.");
        }
    }
}
