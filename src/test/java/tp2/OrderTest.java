package tp2;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    public void testOrderCreation() {
        Restaurant restaurant = new Restaurant("FastFood", null, null);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);

        assertNotNull(order.getId());
        assertEquals(restaurant, order.getRestaurant());
        assertEquals(dishes, order.getDishes());
        assertEquals(20.0, order.getAmount());
        assertEquals("123 Main St", order.getDeliveryLocation());
        assertEquals(customer, order.getCustomer());
    }

    @Test
    public void testSetRestaurant() {
        Restaurant restaurant1 = new Restaurant("FastFood", null, null);
        Restaurant restaurant2 = new Restaurant("PizzaPlace", null, null);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant1, dishes, 20.0, "123 Main St", customer);

        order.setRestaurant(restaurant2);
        assertEquals(restaurant2, order.getRestaurant());
    }

    @Test
    public void testSetDishes() {
        Restaurant restaurant = new Restaurant("FastFood", null, null);
        Map<Dish, Integer> dishes1 = new HashMap<>();
        dishes1.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant, dishes1, 20.0, "123 Main St", customer);

        Map<Dish, Integer> dishes2 = new HashMap<>();
        dishes2.put(new Dish("Pizza", Dish.Size.L), 1);
        order.setDishes(dishes2);
        assertEquals(dishes2, order.getDishes());
    }

    @Test
    public void testSetAmount() {
        Restaurant restaurant = new Restaurant("FastFood", null, null);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);

        order.setAmount(25.0);
        assertEquals(25.0, order.getAmount());
    }

    @Test
    public void testSetDeliveryLocation() {
        Restaurant restaurant = new Restaurant("FastFood", null, null);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);

        order.setDeliveryLocation("456 Elm St");
        assertEquals("456 Elm St", order.getDeliveryLocation());
    }

    @Test
    public void testSetCustomer() {
        Restaurant restaurant = new Restaurant("FastFood", null, null);
        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer1 = new Customer("John", "Doe", "123 Main St", "555-1234");
        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer1);

        Customer customer2 = new Customer("Jane", "Smith", "456 Elm St", "555-5678");
        order.setCustomer(customer2);
        assertEquals(customer2, order.getCustomer());
    }
}