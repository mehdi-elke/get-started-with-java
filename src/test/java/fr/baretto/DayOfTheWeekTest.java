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
        Assertions.assertEquals("Monday", getDay(1));
    }

    @Test
    public void eightShouldPrintError() {
        Assertions.assertEquals("error", getDay(8));
    }

    public String getDay(final int value) {
        return switch (value) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "error";
        };

    }
}
