package tp2;
import java.util.Map;
import java.util.Random;

public class Restaurant {
    private String name;
    private DeliveryPlatform platform;
    private ErrorManagementService errorService;

    public Restaurant(String name, DeliveryPlatform platform, ErrorManagementService errorService) {
        this.name = name;
        this.platform = platform;
        this.errorService = errorService;
    }

    public Order prepareOrder(Map<Dish, Integer> dishes, double amount, String deliveryLocation, Customer customer) throws InterruptedException, OrderPreparationException {
        if (new Random().nextInt(100) < 20) { // 20% chance of failure
            throw new OrderPreparationException("Failed to prepare order at " + name);
        }
        Thread.sleep(new Random().nextInt(3000));
        Order order = new Order(this, dishes, amount, deliveryLocation, customer);
        platform.notifyOrder(order);
        return order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliveryPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(DeliveryPlatform platform) {
        this.platform = platform;
    }
}