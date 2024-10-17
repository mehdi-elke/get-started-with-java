package fr.baretto.tp1;

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
        return switch (value) {
            case 1 -> "monday";
            case 2 -> "tuesday";
            case 3 -> "wednesday";
            case 4 -> "thursday";
            case 5 -> "friday";
            case 6 -> "saturday";
            case 7 -> "sunday";
            default -> "error";
        };
    }
}
