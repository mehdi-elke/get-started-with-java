package fr.baretto.tp3.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Properties properties = DatabaseConfig.loadProperties();
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
// Charger le driver (optionnel avec JDBC 4+)
            Class.forName(properties.getProperty("db.driver"));
// Établir la connexion
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
}
