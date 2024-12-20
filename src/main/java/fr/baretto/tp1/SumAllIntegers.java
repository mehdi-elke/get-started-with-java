package fr.baretto.tp1;

import java.util.Scanner;

public class SumAllIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = 0;
            System.out.println("The sum of all integers from 1 to " + number + " is: " + sum);
        }

        scanner.close();
    }
}
