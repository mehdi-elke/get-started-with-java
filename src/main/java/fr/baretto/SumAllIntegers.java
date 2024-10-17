package fr.baretto;

import java.util.Scanner;

public class SumAllIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a positive number: ");
        int number = scanner.nextInt();

        if (number > 0) {
            int sum = (number * (number + 1)) / 2;
            System.out.println("The sum of all integers from 1 to " + number + " is: " + sum);
        } else {
            System.out.println("Please enter a positive number.");
        }

        // Close the scanner
        scanner.close();
    }
}
