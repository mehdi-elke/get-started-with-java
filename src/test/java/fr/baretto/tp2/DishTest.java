package fr.baretto.tp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DishTest {
    @Test
    public void testConstructor() {
        Dish dish=new Dish("pizza" , DishSize.L );
        Assertions.assertEquals("pizza",dish.getName());
    }
}
