package tp2;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ErrorManagementService errorService = new ErrorManagementService();
        DeliveryPlatform platform = new DeliveryPlatform(errorService);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        try {
            Order order = restaurant.prepareOrder(dishes, 20.0, customer.getDeliveryAddress(), customer);
            platform.notifyOrder(order);
        } catch (InterruptedException | OrderPreparationException e) {
            errorService.logError(e.getMessage());
        }
    }
}