package fr.baretto;
import java.io.*;
import java.util.Scanner;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char lettre;
        String output = "";
        for (int i=0; i<input.length(); i++)
        {
            lettre= input.charAt(i);
            output= lettre+output;
        }

        System.out.println("Reversed string: " + output);

        scanner.close();
    }
}
