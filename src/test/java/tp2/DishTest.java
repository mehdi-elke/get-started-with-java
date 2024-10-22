package tp2;
import fr.tp1.Book;
import fr.tp2.DeliveryPlatform;
import fr.tp2.Dish;
import fr.tp2.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DishTest {
    Dish dish1;
    @BeforeEach
    public void setUp() {
        dish1 = new Dish("30cm Teriyaki",  Dish.DishEnum.L, 10.0);
    }

    @Test
    public void testCreateDish() {

        Assertions.assertEquals(dish1.getName(), "30cm Teriyaki");
        Assertions.assertEquals(dish1.getSize(), Dish.DishEnum.L);
        Assertions.assertEquals(dish1.getPrice(), 10.0);

    }

}
