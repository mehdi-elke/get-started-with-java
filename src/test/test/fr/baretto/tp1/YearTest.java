package fr.baretto.tp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class YearTest {

    @Test
    public void isALeapYear() {
        Assertions.assertTrue(Year.isLeapYear(2000));
    }

    @Test
    public void isNotALeapYear() {
        Assertions.assertFalse(Year.isLeapYear(1900));
    }

}
