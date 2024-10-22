package fr.baretto.tp2;

public class DeliveryPlateform {
    public void update(Order order) {
        deliverOrder(order);
    }

    public void deliverOrder(Order order) {
        String msg = "Votre commande de " + order.getQuantity() + " " + order.getDish().getName() + " a été livrée à cette adresse: " + order.getAddress();
        msg += " pour un montant de " + order.getInitialPrice() * order.getQuantity() + "€";
        System.out.println(msg);
    }
}

