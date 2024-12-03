package fr.baretto.tp2;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static Logger instance;
    private final List<String> logs;

    private Logger() {
        this.logs = new ArrayList<>();
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String timestampedMessage = "[" + java.time.LocalDateTime.now() + "] " + message;
        logs.add(timestampedMessage);
    }

    public void getLogs(){
        System.out.println("===== Journal des événements =====");
        logs.forEach(System.out::println);
        System.out.println("===================================");
    }
}
