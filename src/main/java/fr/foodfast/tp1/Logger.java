package fr.foodfast.tp1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static Logger instance;
    private final List<String> logs = new ArrayList<>();

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Méthode pour enregistrer un événement
    public void logEvent(String eventDescription) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        String logEntry = timestamp + " - " + eventDescription;
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    // Méthode pour récupérer tous les logs
    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
}
