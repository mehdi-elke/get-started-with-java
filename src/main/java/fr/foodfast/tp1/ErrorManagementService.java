package fr.foodfast.tp1;

import java.util.ArrayList;
import java.util.List;

public class ErrorManagementService {
    private final List<String> errorLogs = new ArrayList<>();

    public void logError(String errorMessage) {
        errorLogs.add(errorMessage);
        System.err.println("Erreur enregistrée : " + errorMessage); // Affichage pour le suivi
    }

    public List<String> getErrorLogs() {
        return new ArrayList<>(errorLogs); // Retourne une copie pour éviter les modifications
    }
}
