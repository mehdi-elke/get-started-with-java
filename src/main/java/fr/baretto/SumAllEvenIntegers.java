package fr.baretto;

import java.util.Scanner;

public class SumAllEvenIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = 0;
            for (int i = 2; i <= number; i += 2) {
                sum = sum + i;
            }
            System.out.println("The sum of all even integers from 1 to " + number + " is: " + sum);
        }

        scanner.close();
    }
}