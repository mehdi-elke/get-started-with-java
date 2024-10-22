package fr.baretto.tp2;

import java.util.Random;

public class DeliveryPlateform {

    void delivery(Order order) throws InterruptedException {
        System.out.println("Livraisons de la commande à " + order.getDeliveryPlace() + "...");
        Thread.sleep(new Random().nextInt(3000));
        System.out.println("Commande livrée, vous payez " + order.getPrice() + "sivouplé.");
    }
}
