package tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryPlatform implements Observer {

    private List<Restaurant> subscribedRestaurants = new ArrayList<>();
    private ExecutorService executorService;

    public DeliveryPlatform() {

        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void subscribeRestaurant(Restaurant restaurant) {
        subscribedRestaurants.add(restaurant);
        restaurant.addObserver(this);
    }

    public void unsubscribeRestaurant(Restaurant restaurant) {
        subscribedRestaurants.remove(restaurant);
        restaurant.removeObserver(this);
    }

    @Override
    public void update(Order order) {

        executorService.submit(() -> {
            System.out.println("Processing order from " + order.getRestaurant().getName());
            delivery(order);
        });
    }

    public void delivery(Order order) {
        System.out.println("La commande est livrée: " + order);
    }

    public void shutdown() {
        executorService.shutdown();
        System.out.println("Delivery platform shutting down.");
    }
}
