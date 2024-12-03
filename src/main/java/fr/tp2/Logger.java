package fr.tp2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;

    private static final String LOG_FILE = "foodfast.log";

    private Logger() {}

    public static void logEvent(String eventDescription) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = timestamp + " - " + eventDescription;

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier de log : " + e.getMessage());
        }
    }

    public static void logOrder(String orderDetails) {
        logEvent("Commande reçue : " + orderDetails);
    }

    public static void logDelivery(String deliveryDetails) {
        logEvent("Livraison effectuée : " + deliveryDetails);
    }
}
