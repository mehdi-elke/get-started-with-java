package fr.baretto.tp1;

public class Year {

    public static boolean isLeapYear(final int value) {
        if (value % 400 == 0) {
            return true;
        }
        if (value % 4 == 0 && value % 100 != 0) {
            return true;
        }

        return false;
    }
}
