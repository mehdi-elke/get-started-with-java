package fr.tp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryPlatform implements OrderObserver {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final ExecutorService service = Executors.newCachedThreadPool();
    private final Set<String> orderIds = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        restaurant.addObserver(this);
    }

    public void delivery(Order order) {
        if (orderIds.contains(order.getId())) {
            System.err.printf("Duplicate order detected: " + order.getId());
            order.status = OrderStatus.IN_ERROR;
            return;
        }
        service.submit(() -> {
            orderIds.add(order.getId());
            System.out.println("Order is ready for delivery to " + order.getAddress());
            order.status = OrderStatus.DELIVERED;
        });
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.READY_FOR_DELIVERY) {
            delivery(order);
        }
    }
}