package fr.baretto;

import java.util.Scanner;

public class FizzBuzz {

    public static String get(int input) {
        int remainderFive = input % 5;
        int remainderThree = input % 3;
        if (remainderFive == 0 && remainderThree == 0) {
            return "FizzBuzz";
        }
        else if (remainderThree == 0) {
            return "Fizz";
        }
        else if (remainderFive == 0) {
            return "Buzz";
        }
        return input + "";
    };
}
