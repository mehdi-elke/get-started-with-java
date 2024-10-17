package fr.baretto;

import java.util.Scanner;

public class SumAllEvenIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer un nb positif: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Stp un nb positif.");
        } else {
            int sum = 0;
            for (int i = 2; i <= number; i += 2) {
                sum += i;
            }
            System.out.println("La somme de tous les entiers pairs de " + number + " est: " + sum);
        }

        scanner.close();
    }
}
