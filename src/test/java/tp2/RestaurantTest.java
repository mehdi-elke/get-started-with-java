package tp2;

import fr.tp2.Dish;
import fr.tp2.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantTest {
    Restaurant sacha;
    Restaurant mcDonalds;
    @BeforeEach
    public void setUp() {
        sacha = new Restaurant("Sacha & co");
        mcDonalds = new Restaurant("McDonald's");
    }

    @Test
    public void testCreateRestaurant() {
        Assertions.assertEquals(sacha.getName(), "Sacha & co");
        Assertions.assertEquals(mcDonalds.getName(), "McDonald's");
    }

}
