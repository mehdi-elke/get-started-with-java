package fr.tp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorManagementService {
    private static final Map<String, List<Exception>> errorLogs = new HashMap<>();

    public static void logError(Exception error) {
        if (!errorLogs.containsKey(error.getClass().getSimpleName())) {
            errorLogs.put(error.getClass().getSimpleName(), new ArrayList<>());
            return;
        }
        errorLogs.get(error.getClass().getSimpleName()).add(error);
    }

    public void getErrorLogs() {
        for (String key : errorLogs.keySet()) {
            System.out.println("[" + key + "] " + errorLogs.get(key).size() + " errors");
            errorLogs.get(key).forEach(e -> System.out.println("[" + key + "] " + e.getMessage()));
        }
    }

    public static boolean isEmpty() {
        return errorLogs.isEmpty();
    }

}