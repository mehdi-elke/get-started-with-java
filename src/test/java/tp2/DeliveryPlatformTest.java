package tp2;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeliveryPlatformTest {
    @Test
    public void testDeliver() throws DeliveryProcessingException {
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Random random = mock(Random.class);
        when(random.nextInt(100)).thenReturn(50);
        DeliveryPlatform platform = new DeliveryPlatform(errorService, random);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);
        platform.deliver(order);

        // Verify that the order was delivered and an invoice was created
        BillingService billingService = platform.getBillingService();
        Invoice invoice = billingService.getInvoice(order.getId());
        assertNotNull(invoice);
        assertEquals(Invoice.Status.CREATED, invoice.getStatus());

        // Simulate delivery completion
        platform.completeDelivery(order);
        assertEquals(Invoice.Status.CLOSED, invoice.getStatus());
        assertEquals(Order.Status.COMPLETED, order.getStatus());
    }

    @Test
    public void testNotifyOrder() {
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Random random = mock(Random.class);
        when(random.nextInt(100)).thenReturn(50); // Simuler un succès de livraison
        DeliveryPlatform platform = new DeliveryPlatform(errorService, random);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);
        platform.notifyOrder(order);

        // Verify that the order was delivered and an invoice was created
        BillingService billingService = platform.getBillingService();
        Invoice invoice = billingService.getInvoice(order.getId());
        assertNotNull(invoice);
        assertEquals(Invoice.Status.CREATED, invoice.getStatus());

        // Simulate delivery completion
        platform.completeDelivery(order);
        assertEquals(Invoice.Status.CLOSED, invoice.getStatus());
        assertEquals(Order.Status.COMPLETED, order.getStatus());
    }

    @Test
    public void testCancelOrderBeforeDelivery() {
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Random random = mock(Random.class);
        when(random.nextInt(100)).thenReturn(50); // Simuler un succès de livraison
        DeliveryPlatform platform = new DeliveryPlatform(errorService, random);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);
        platform.notifyOrder(order);

        // Cancel the order before delivery
        platform.cancelOrder(order);
        assertEquals(Order.Status.CANCELLED, order.getStatus());

        // Verify that the order is not delivered
        platform.completeDelivery(order);
        assertEquals(Order.Status.CANCELLED, order.getStatus());
    }

    @Test
    public void testCancelOrderAfterDelivery() {
        ErrorManagementService errorService = mock(ErrorManagementService.class);
        Random random = mock(Random.class);
        when(random.nextInt(100)).thenReturn(50); // Simuler un succès de livraison
        DeliveryPlatform platform = new DeliveryPlatform(errorService, random);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);
        platform.notifyOrder(order);

        // Simulate delivery completion
        platform.completeDelivery(order);
        assertEquals(Order.Status.COMPLETED, order.getStatus());

        // Cancel the order after delivery
        platform.cancelOrder(order);
        assertEquals(Order.Status.CANCELLED, order.getStatus());
    }
}