package fr.baretto.tp2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    @Test
    void testSingletonInstance() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assert logger1 == logger2;
    }

    @Test
    void testLogEvent() {
        Logger logger = Logger.getInstance();

        // Effacer les anciennes entrées (si nécessaire)
        clearLogForTest(logger);

        // Enregistrer un événement
        String event = "Test event 1";
        logger.log(event);

        // Récupérer les entrées du journal
        List<String> logEntries = getLogsForTest(logger);

        // Vérifier que l'événement est enregistré
        assertEquals(1, logEntries.size(), "Logger should have one entry");
        assertTrue(logEntries.get(0).contains(event), "Log entry should contain the event description");
    }

    private List<String> getLogsForTest(Logger logger) {
        try {
            var field = Logger.class.getDeclaredField("logs");
            field.setAccessible(true);
            return (List<String>) field.get(logger);
        } catch (Exception e) {
            throw new RuntimeException("Unable to access logs field for testing", e);
        }
    }

    private void clearLogForTest(Logger logger) {
        getLogsForTest(logger).clear();
    }
}
