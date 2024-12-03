package tp2;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class RestaurantTest {
    @Test
    public void testPrepareOrder() throws InterruptedException, OrderPreparationException {
        DeliveryPlatform platform = mock(DeliveryPlatform.class);
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = restaurant.prepareOrder(dishes, 20.0, customer.getDeliveryAddress(), customer);
        verify(platform).notifyOrder(order);
    }

    @Test
    public void testPrepareOrderFailure() throws InterruptedException {
        DeliveryPlatform platform = mock(DeliveryPlatform.class);
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        try {
            restaurant.prepareOrder(dishes, 20.0, customer.getDeliveryAddress(), customer);
            fail("Expected OrderPreparationException to be thrown");
        } catch (OrderPreparationException e) {
            assertEquals("Failed to prepare order at FastFood", e.getMessage());
        }
    }
}