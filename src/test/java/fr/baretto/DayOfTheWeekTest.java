package fr.baretto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayOfTheWeekTest {

    @Test
    public void zeroShouldPrintError() {
        Assertions.assertEquals("error", getDay(0));
    }

    @Test
    public void oneShouldPrintMonday() {
        Assertions.assertEquals("monday", getDay(1));
    }

    @Test
    public void eightShouldPrintError() {
        Assertions.assertEquals("error", getDay(8));
    }

    public String getDay(final int value) {
        return null;
    }
}
