package tp2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryPlatform implements Subscriber {
    private Set<String> processedOrderIds = new HashSet<>();
    private ExecutorService executorService;

    public DeliveryPlatform(EventBus eventBus) {
        this.executorService = Executors.newFixedThreadPool(4);
        eventBus.subscribe(this); // S'abonner au EventBus
    }

    @Override
    public void handleEvent(Order order) {
        executorService.submit(() -> processOrder(order));
    }

    private void processOrder(Order order) {
        synchronized (processedOrderIds) {
            if (processedOrderIds.contains(order.getId())) {
                System.out.println("Duplicate order detected and ignored: " + order);
                return;
            }
            processedOrderIds.add(order.getId());
        }
        delivery(order);
    }

    public void delivery(Order order) {
        System.out.println("La commande est livrée: " + order);
    }

    public void shutdown() {
        executorService.shutdown();
        System.out.println("Delivery platform shutting down.");
    }
}
