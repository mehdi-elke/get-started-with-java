package tp2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String timestampedMessage = LocalDateTime.now() + ": " + message;
        logs.add(timestampedMessage);
        System.out.println(timestampedMessage);
    }

    public List<String> getLogs() {
        return logs;
    }
}