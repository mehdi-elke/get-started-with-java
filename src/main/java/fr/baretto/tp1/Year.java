package fr.baretto.tp1;

public class Year {

    public static boolean isLeapYear(final int value) {
        if (value % 100 == 0) {
            return value % 400 == 0;
        }
        return value % 4 == 0;
    }
}
