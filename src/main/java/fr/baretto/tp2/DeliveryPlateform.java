package fr.baretto.tp2;

import java.util.Random;

public class DeliveryPlateform implements Observer{

    void delivery(Order order) throws InterruptedException {
        System.out.println("Livraisons de la commande à " + order.getDeliveryPlace() + "...");
        Thread.sleep(new Random().nextInt(3000));
        System.out.println("Commande livrée, vous devez payer " + order.getPrice() + " sivouplé.");
    }

    @Override
    public void update(String event, Order order) throws InterruptedException {
        if(event.equals("finished order")){
            this.delivery(order);
        }
    }
}
