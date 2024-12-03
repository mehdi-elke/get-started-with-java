package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class RestaurantTest {
    @Test
    public void testPrepareOrder() throws OrderPreparationException, InterruptedException {
        DeliveryPlatform platform = mock(DeliveryPlatform.class);
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        assertDoesNotThrow(() -> restaurant.prepareOrder(dishes, 20.0, customer.getDeliveryAddress(), customer));
    }

    @Test
    public void testPrepareOrderFailure() throws InterruptedException {
        DeliveryPlatform platform = mock(DeliveryPlatform.class);
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> emptyDishes = new HashMap<>();
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        OrderPreparationException exception = assertThrows(OrderPreparationException.class, () -> {
            restaurant.prepareOrder(emptyDishes, 20.0, customer.getDeliveryAddress(), customer);
        });

        assertEquals("Failed to prepare order at FastFood", exception.getMessage());
    }
}