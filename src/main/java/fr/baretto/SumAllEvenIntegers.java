package fr.baretto;

import java.util.Scanner;

public class SumAllEvenIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un entier positif : ");
        int number = scanner.nextInt();

        int sum = 0;

        if (number > 0) {
            for (int i = 2; i <= number; i += 2) {
                sum += i;
            }
            System.out.println("La somme de tous les entiers pairs de 1 à " + number + " est : " + sum);
        } else {
            System.out.println("Veuillez entrer un nombre positif.");
        }

        scanner.close();
    }
}
