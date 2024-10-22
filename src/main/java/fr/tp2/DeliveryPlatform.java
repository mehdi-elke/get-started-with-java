package fr.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryPlatform implements OrderObserver {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final ExecutorService service = Executors.newCachedThreadPool();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        restaurant.addObserver(this);
    }

    public void delivery(Order order) {
        service.submit(() -> {
            System.out.println("Order is ready for delivery to " + order.getAddress());
        });
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.READY_FOR_DELIVERY) {
            order.status = OrderStatus.DELIVERED;
            delivery(order);
        }
    }
}