package fr.tp2;

import java.util.*;

public class DeliveryPlatform extends Subscriber {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final Set<String> orderIds = new HashSet<>();

    @Override
    public List<Class<? extends Event>> getSuscribedEvents() {
        return Arrays.asList(OrderEvent.class, DeliveryEvent.class);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void handleDeliveryEvent(Event event) throws Exception {
        if (!(event instanceof DeliveryEvent)) {
            return;
        }
        Order order = (Order) event.getObject();


        System.out.println("[StatusChange] Order " + order.getId() + " is now " + order.getStatus());
    }

    public void handleOrderEvent(Event event) throws Exception {
        if (!(event instanceof OrderEvent)) {
            return;
        }
        Order order = (Order) event.getObject();

        if (orderIds.contains(order.getId())) {
            System.err.printf("Duplicate order detected: " + order.getId());
            order.setStatus(OrderStatus.IN_ERROR);
            return;
        }
        orderIds.add(order.getId());

        System.out.println("[Order] New order received");
    }


}