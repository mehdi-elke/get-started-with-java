package fr.baretto.tp2;

import java.util.ArrayList;
import java.util.List;

public class ErrorManagementService {
    private static final List<String> errorLog = new ArrayList<>();

    public static void logError(String errorMessage) {
        errorLog.add(errorMessage);
        System.err.println("Erreur enregistrée : " + errorMessage);
    }

    public static List<String> getErrorLog() {
        return new ArrayList<>(errorLog);
    }
}
