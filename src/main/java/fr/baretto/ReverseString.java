package fr.baretto;

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
    public static String reverseStr(String str) {
        String inverted = ""; 

        
        for (int i = str.length() - 1; i >= 0; i--) {
            inverted += str.charAt(i);
        }

        return inverted; 
    }
}
