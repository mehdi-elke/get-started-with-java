package fr.baretto;

import java.util.List;

public class FizzBuzz {

    public static String get(final int value) {
        if (value % 15 == 0){ // ou 5 == 0 && value % 3
            return "FizzBuzz";
        } else if (value % 5 ==0){
            return "Buzz";
        } else if (value % 3 ==0){
            return "Fizz";
        }else{
            return String.valueOf(value);
        }
    }
}
