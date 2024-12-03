package Tp2;

import java.util.ArrayList;
import java.util.List;

public class ErrorManagementService {
    private List<String> errorLog = new ArrayList<>();

    public void logError(String errorMessage) {
        errorLog.add(errorMessage);
        System.err.println("Erreur enregistrée : " + errorMessage);
    }

    public void printErrorLog() {
        System.out.println("\nJournal des erreurs :");
        for (String error : errorLog) {
            System.out.println(error);
        }
    }
}