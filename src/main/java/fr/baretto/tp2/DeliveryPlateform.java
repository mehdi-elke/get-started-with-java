package fr.baretto.tp2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DeliveryPlateform {
    private Set<Order> uniqueOrders;

    public DeliveryPlateform() {
        uniqueOrders = new HashSet<>();
    }

    public void update(Order order) throws DeliveryProcessingException {
        if (uniqueOrders.add(order)) {
            deliverOrder(order);
            System.out.println("Nouvelle commande reçue pour livraison : " +
                    order.getDish().getName() + ", Quantité : " + order.getQuantity() +
                    ", Adresse : " + order.getAddress());
        } else {
            System.out.println("Commande déjà existante et ignorée : " + order.getDish().getName() +
                    ", Quantité : " + order.getQuantity() + ", Adresse : " + order.getAddress());
        }
    }

    public void deliverOrder(Order order) throws DeliveryProcessingException {
        if (new Random().nextInt(100) < 20) { // 20% de probabilité d'échec
            throw new DeliveryProcessingException("Erreur : La commande n'a pas pu être livrée.");
        }
        uniqueOrders.add(order); // Ensure the order is added to the set
        String msg = "Votre commande de " + order.getQuantity() + " " + order.getDish().getName() +
                " a été livrée à cette adresse: " + order.getAddress();
        msg += " pour un montant de " + order.getInitialPrice() * order.getQuantity() + "€";
        System.out.println(msg);
    }


    public void subscribe(Restaurant restaurant) {
        System.out.println("Inscription à la plateforme de livraison du restaurant " + restaurant.getName());
    }

    public int getOrderCount() {
        return uniqueOrders.size();
    }

    public boolean containsOrder(Order order) {
        return uniqueOrders.contains(order);
    }
}