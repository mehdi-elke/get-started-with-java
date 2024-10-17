package fr.baretto;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        int input = scanner.nextInt();
        int remainderFive = input % 5;
        int remainderThree = input % 3;
        if (remainderFive == 0 && remainderThree == 0) {
            System.out.print("FizzBuzz");
        }
        else if (remainderThree == 0) {
            System.out.print("Fizz");
        }
        else if (remainderFive == 0) {
            System.out.print( "Buzz");
        }
        System.out.print("");
    };
}
