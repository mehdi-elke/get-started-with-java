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

    // Assure-toi qu'il n'y a qu'une seule définition de cette méthode
    public String getDay(final int value) {
        switch (value) {
            case 1:
                return "monday";
            case 2:
                return "tuesday";
            case 3:
                return "wednesday";
            case 4:
                return "thursday";
            case 5:
                return "friday";
            case 6:
                return "saturday";
            case 7:
                return "sunday";
            default:
                return "error";
        }
    }
}
