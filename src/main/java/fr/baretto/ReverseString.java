package fr.baretto;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne : ");
        String input = scanner.nextLine();

        System.out.println("Chaîne inversée : " + new StringBuilder(input).reverse().toString());

        scanner.close();
    }
}
