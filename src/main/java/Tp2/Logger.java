package Tp2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final List<String> logs;

    // Instance unique du Logger
    private static Logger instance = null;

    private Logger() {
        logs = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void logEvent(String eventDescription) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(timestamp + " - " + eventDescription);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs); // Retourne une copie pour éviter les modifications
    }
}
