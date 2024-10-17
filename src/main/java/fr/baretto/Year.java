package fr.baretto;

public class Year {

    public static boolean isLeapYear(final int value) {
        if (value % 400 == 0) {
            return true;
        } else if (value % 100 == 0) {
            return false;
        } else if (value % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test des années bissextiles :");

        System.out.println("2000 est bissextile : " + (isLeapYear(2000) ? "Oui" : "Non"));
        System.out.println("2400 est bissextile : " + (isLeapYear(2400) ? "Oui" : "Non"));
        System.out.println("2008 est bissextile : " + (isLeapYear(2008) ? "Oui" : "Non"));

        System.out.println("1700 est bissextile : " + (isLeapYear(1700) ? "Oui" : "Non"));
        System.out.println("1800 est bissextile : " + (isLeapYear(1800) ? "Oui" : "Non"));
        System.out.println("1900 est bissextile : " + (isLeapYear(1900) ? "Oui" : "Non"));
        System.out.println("2100 est bissextile : " + (isLeapYear(2100) ? "Oui" : "Non"));
        System.out.println("2017 est bissextile : " + (isLeapYear(2017) ? "Oui" : "Non"));
        System.out.println("2018 est bissextile : " + (isLeapYear(2018) ? "Oui" : "Non"));
        System.out.println("2019 est bissextile : " + (isLeapYear(2019) ? "Oui" : "Non"));
    }
}
