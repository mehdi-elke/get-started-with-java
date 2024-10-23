package fr.baretto.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeliveryPlateform implements Observer{
    private List<Order> orders;

    public DeliveryPlateform() {
        this.orders = new ArrayList<>();
    }

    void delivery(Order order) throws InterruptedException {
        if(orders.contains(order)){
            System.out.println("Commande déjà passée");
        }else{
            System.out.println("Livraisons de la commande à " + order.getDeliveryPlace() + "...");
            Thread.sleep(new Random().nextInt(3000));
            System.out.println("Commande livrée, vous devez payer " + order.getPrice() + " sivouplé.");
            orders.add(order);
        }
    }

    @Override
    public void update(String event, Order order) throws InterruptedException {
        if(event.equals("finished order")){
            this.delivery(order);
        }
    }
}
