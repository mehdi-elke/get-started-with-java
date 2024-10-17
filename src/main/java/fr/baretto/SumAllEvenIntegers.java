package fr.baretto;

import java.util.Scanner;

public class SumAllEvenIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a positive number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a positive number.");
        } else {
            int sumEven = 0;

            for (int i = 2; i <= number; i += 2) {
                sumEven += i;
            }

            System.out.println("The sum of all even integers from 1 to " + number + " is: " + sumEven);
        }

        // Close the scanner
        scanner.close();
    }
}
