package fr.baretto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

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

    public static String getDay(final int value) {
        if (value == 0 || (value > 7 || value < 0)) {
            return "error";
        }

        if (value == 1) {
            return "lundi";
        }
        if (value == 2) {
            return "mardi";
        }
        if (value == 3) {
            return "mercredi";
        }
        if (value == 4) {
            return "jeudi";
        }
        if (value == 5) {
            return "vendredi";
        }
        if (value == 6) {
            return "samedi";
        }
        return "dimanche";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        String input = scanner.nextLine();
        System.out.println(getDay(Integer.parseInt(input)));
    }
}
