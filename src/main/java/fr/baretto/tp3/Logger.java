package fr.baretto.tp3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private static List<String> logs = new ArrayList<>();

    private Logger() {}

    public void addLog(String description) {
        LocalDateTime now = LocalDateTime.now();
        logs.add("[" + now.toString() + "] " + description);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
