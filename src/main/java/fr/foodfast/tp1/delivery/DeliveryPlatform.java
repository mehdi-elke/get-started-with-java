package fr.foodfast.tp1.delivery;
import fr.foodfast.tp1.*;
import fr.foodfast.tp1.event.Event;
import fr.foodfast.tp1.order.Order;
import fr.foodfast.tp1.order.OrderEvent;

import java.util.*;

public class DeliveryPlatform implements Subscriber {
    private Set<Order> orders = new HashSet<>();
    private Set<Restaurant> restaurants = new HashSet<>();
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>(Comparator.comparing(Order::getPrice));

    public void delivery(Order order) {
        System.out.println("Livraison de la commande de " + order.getLocation() + " à " + order.getAddress() + " pour un montant de " + order.getPrice() + "€ avec x"+ order.getQuantity() + " " + order.getDish().getName());
        orderQueue.poll();
    }

    public void update(Order order) {
        System.out.println("Commande de " + order.getQuantity() + " " + order.getDish().getName() + " pour " + order.getPrice() + "€ à livrer à " + order.getAddress());

        if (!orders.contains(order)) {
            orders.add(order);
            orderQueue.add(order);
            processAllOrders();
            //delivery(order);
        } else {
            System.out.println("Commande en doublon détectée. La commande ne sera pas traitée.");
        }
    }

    public Restaurant subscribeRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println(restaurant.getName() + " est abonné à la plateforme de livraison.");
        return restaurant;
    }

    public void processAllOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            delivery(order);
        }
    }

    @Override
    public void handleEvent(Event event) {
        if (event instanceof OrderEvent) {
            OrderEvent orderEvent = (OrderEvent) event;
            System.out.println("Delivery platform notified: Order prepared -> " + orderEvent.getOrder().getId());
        } else if (event instanceof DeliveryEvent) {
            DeliveryEvent deliveryEvent = (DeliveryEvent) event;
            System.out.println("Delivery platform notified: Delivery -> " +
                    deliveryEvent.getOrder().getId() + ", Status: " + deliveryEvent.getStatus());
        }
    }

}