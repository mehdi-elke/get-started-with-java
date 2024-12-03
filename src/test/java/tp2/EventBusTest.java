package tp2;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class EventBusTest {
    @Test
    public void testEventSavedToDatabase() {
        EventBus eventBus = new EventBus();
        ErrorManagementService errorService = new ErrorManagementService();
        Random random = new Random();
        DeliveryPlatform platform = new DeliveryPlatform(errorService, random);
        Restaurant restaurant = new Restaurant("FastFood", platform, errorService);

        Map<Dish, Integer> dishes = new HashMap<>();
        dishes.put(new Dish("Burger", Dish.Size.M), 2);
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");

        Order order = new Order(restaurant, dishes, 20.0, "123 Main St", customer);
        Event event = new OrderEvent(order);

        eventBus.publish(event);

        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, event.getId(), java.sql.Types.OTHER); // Use setObject with Types.OTHER for UUID
            ResultSet resultSet = statement.executeQuery();

            assertTrue(resultSet.next());
            assertEquals(event.getId(), resultSet.getObject("id"));
            assertEquals(event.getType().name(), resultSet.getString("type"));
            assertNotNull(resultSet.getTimestamp("event_timestamp"));
            assertEquals(event.toString(), resultSet.getString("details"));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while verifying event in database");
        }
    }
}