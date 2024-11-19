package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DishTest {

    @Test
    void testDishCreation() {
        Dish dish = new Dish("BigMac", Dish.Taille.S);

        assertEquals("BigMac", dish.getNom());
        assertEquals(Dish.Taille.S, dish.getTaille());
    }

    @Test
    void testDishToString() {
        Dish dish = new Dish("McFries", Dish.Taille.M);

        String expected = "Dish{nom='McFries', taille=M}";
        assertEquals(expected, dish.toString());
    }
}
