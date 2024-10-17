package fr.baretto;

public class Year {

    public static boolean isLeapYear(final int value) {

        // Divisible par 400 == bissextile & Divisible par 4 mais pas par 100 == bissextile
        if (value % 400 == 0 || (value % 4 == 0 && value % 100 != 0)) {
            return true;
        } else if (value % 100 == 0 && value % 400 != 0 || value % 4 != 0) {
            // Divisible par 100 mais pas par 400 != bissextile & Non divisible par 4 != bissextile
            return false;
        }

        return false;
    }
}
