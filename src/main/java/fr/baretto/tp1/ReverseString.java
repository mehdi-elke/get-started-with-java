package fr.baretto.tp1;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String inverted = "";

        System.out.println("Reversed string: " + inverted);

        scanner.close();
    }
}
