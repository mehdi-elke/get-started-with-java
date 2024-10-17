package fr.baretto;

public class Year {


    public static boolean isLeapYear(final int value) {

        if (value % 400 == 0) {
            return true;
        }

        else if (value % 100 == 0) {
            return false;
        }

        else if (value % 4 == 0) {
            return true;
        }

        else {
            return false;
        }
    }
}
