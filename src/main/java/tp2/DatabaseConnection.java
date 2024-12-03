package tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Properties properties = DatabaseConfig.loadProperties();
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            // Load the driver (optional with JDBC 4+)
            Class.forName(properties.getProperty("db.driver"));
            // Establish the connection
            return DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
}