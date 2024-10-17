package fr.baretto;

public class Year {

    public static boolean isLeapYear(final int value) {
        return value % 4 == 0 && (value % 100 != 0 || value % 400 == 0);
    }
}
