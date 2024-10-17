package fr.baretto;

import java.util.Scanner;

public class SumAllIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un entier positif : ");
        int number = scanner.nextInt();

        int sum = 0;

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println("La somme de tous les entiers de 1 à " + number + " est : " + sum);
        } else {
            System.out.println("Veuillez entrer un nombre positif.");
        }

        scanner.close();
    }
}
