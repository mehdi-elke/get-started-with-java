package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeliveryPlateform implements Subscriber {
    private List<Order> orders;

    public DeliveryPlateform() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void handleEvent(Order order) throws InterruptedException {
        if(orders.contains(order)){
            System.out.println("Commande déjà passée");
        }else{
            OrderEvent orderEvent = new OrderEvent(order);
            DeliveryEvent deliveryEvent = new DeliveryEvent(orderEvent, DeliveryStatus.IN_DELIVERY);
            var random = Math.random()*(15 -2) + 2*1000;
            System.out.println("Livraisons de la commande à " + order.getDeliveryPlace() + "...");
            Thread.sleep((int)random);
            DeliveryEvent deliveryEvent2 = new DeliveryEvent(orderEvent, DeliveryStatus.DELIVERED);
            System.out.println("Commande livrée, vous devez payer " + order.getPrice() + " sivouplé.");
            orders.add(order);
        }
    }
}
