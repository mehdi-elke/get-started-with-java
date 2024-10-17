package fr.baretto.tp1;

import java.util.Scanner;

public class SumAllEvenIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        int sum = 0;
        if (number > 0) {
            for (int i = 0; i <= number; i = i + 2) {
                sum += i;
            }
            System.out.println("The sum of all even integers from 1 to " + number + " is: " + sum);
        } else {
            System.out.println("The sum of all even integers from 1 to " + number + " is: " + sum);
        }

        scanner.close();
    }
}
