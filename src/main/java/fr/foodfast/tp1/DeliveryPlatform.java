package fr.foodfast.tp1;
import java.util.*;

public class DeliveryPlatform implements OrderObserver {
    private Set<Order> orders = new HashSet<>();

    private Set<Restaurant> restaurants = new HashSet<>();

    private PriorityQueue<Order> orderQueue = new PriorityQueue<>(Comparator.comparing(Order::getPriority));

    @Override
    public void update(Order order) {
        System.out.println("Nouvelle commande reçue de " + order.getRestaurant().getName());

        if (!orders.contains(order)) {
            orders.add(order);
            orderQueue.add(order);
            delivery(order); 
        } else {
            System.out.println("Commande en doublon détectée. La commande ne sera pas traitée.");
        }
    }

    public void delivery(Order order) {
        System.out.println("Livraison de la commande du restaurant " + order.getRestaurant().getName()
                + " à " + order.getDeliveryLocation() + " pour un montant de : " + order.getAmount());
        orderQueue.poll();
    }

    public void subscribeRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        restaurant.addObserver(this); // Le restaurant notifie la plateforme
        System.out.println(restaurant.getName() + " est abonné à la plateforme de livraison.");
    }

    public void processAllOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            delivery(order);
        }
    }
}