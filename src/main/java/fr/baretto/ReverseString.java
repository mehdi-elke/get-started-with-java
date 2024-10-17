package fr.baretto;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String inverted = new StringBuilder(input).reverse().toString();

        System.out.println("Reversed string: " + inverted);

        scanner.close();
    }
}
