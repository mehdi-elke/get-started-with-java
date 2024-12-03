package tp2;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    @Test
    public void testConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        } catch (Exception e) {
            fail("Connection to the database failed: " + e.getMessage());
        }
    }
}
