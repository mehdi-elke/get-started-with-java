package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {
    @Test
    public void testSingletonLogger() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assertSame(logger1, logger2);
    }

    @Test
    public void testLog() {
        Logger logger = Logger.getInstance();
        String logEntry = "Test log entry";
        logger.log(logEntry);

        boolean logFound = logger.getLogs().stream().anyMatch(log -> log.contains(logEntry));
        assertTrue(logFound, "Log entry should be present in the logs");
    }
}