package fr.baretto.tp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    public void forOneShouldPrint1() {
        Assertions.assertEquals("1", FizzBuzz.get(1));
    }

    @Test
    public void forTwoShouldPrint1() {
        Assertions.assertEquals("2", FizzBuzz.get(2));
    }

    @Test
    public void forThreeShouldPrintFizz() {
        Assertions.assertEquals("Fizz", FizzBuzz.get(3));
    }

    @Test
    public void forNineShouldPrintFizz() {
        Assertions.assertEquals("Fizz", FizzBuzz.get(9));
    }

    @Test
    public void shouldPrintBuzz() {
        Assertions.assertEquals("Buzz", FizzBuzz.get(5));
        Assertions.assertEquals("Buzz", FizzBuzz.get(10));
        Assertions.assertEquals("Buzz", FizzBuzz.get(20));
        Assertions.assertEquals("Buzz", FizzBuzz.get(25));
    }

    @Test
    public void shouldPrintFizzBuzz() {
        Assertions.assertEquals("FizzBuzz", FizzBuzz.get(15));
        Assertions.assertEquals("FizzBuzz", FizzBuzz.get(30));
        Assertions.assertEquals("FizzBuzz", FizzBuzz.get(45));
        Assertions.assertEquals("FizzBuzz", FizzBuzz.get(60));
    }

}
