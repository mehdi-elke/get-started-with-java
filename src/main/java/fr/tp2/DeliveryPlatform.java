package fr.tp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeliveryPlatform implements Subscriber {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final Set<String> orderIds = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void handleEvent(Order order) {
        if (orderIds.contains(order.getId())) {
            System.err.printf("Duplicate order detected: " + order.getId());
            order.status = OrderStatus.IN_ERROR;
            return;
        }
        orderIds.add(order.getId());
        System.out.println("Order is ready for delivery to " + order.getAddress());
        order.status = OrderStatus.DELIVERED;
    }
}