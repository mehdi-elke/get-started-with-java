package fr.baretto.tp2;

public class DeliveryPlateform {
    public void update(Order order) {
        deliverOrder(order);
        System.out.println("Nouvelle commande reçue pour livraison : " +
                order.getDish().getName() + ", Quantité : " + order.getQuantity() +
                ", Adresse : " + order.getAddress());
    }

    public void deliverOrder(Order order) {
        String msg = "Votre commande de " + order.getQuantity() + " " + order.getDish().getName() + " a été livrée à cette adresse: " + order.getAddress();
        msg += " pour un montant de " + order.getInitialPrice() * order.getQuantity() + "€";
        System.out.println(msg);
    }

    public void subscribe(Restaurant restaurant) {
        System.out.println("Inscription à la plateforme de livraison du restaurant " + restaurant.getName());
    }
}

