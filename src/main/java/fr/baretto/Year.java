package fr.baretto;

import java.util.Scanner;

public class Year {

    public static boolean isLeapYear(final int value) {
        if (value % 4 == 0) {
            if (value % 100 == 0) {
                if (value % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        String input = scanner.nextLine();
        System.out.println(isLeapYear(Integer.parseInt(input)));
    }
}
