package fr.foodfast.tp1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = Logger.getInstance();
    }

    @Test
    public void testLogCommand() {
        logger.logCommand("Order #1234");
        assertFalse(logger.getLogs().contains("Order #1234"));
    }

    @Test
    public void testLogDelivery() {
        logger.logDelivery("Delivery #5678");
        assertFalse(logger.getLogs().contains("Delivery #5678"));
    }

    @Test
    public void testGetLogs() {
        logger.logCommand("Order #1234");
        logger.logDelivery("Delivery #5678");

        assertEquals(3, logger.getLogs().size());
        assertFalse(logger.getLogs().contains("Order #1234"));
        assertFalse(logger.getLogs().contains("Delivery #5678"));
    }
}