package tp2;
import fr.tp1.Book;
import fr.tp2.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DishTest {
    @Test
    public void testCreateDish() {
        Dish dish1 = new Dish("30cm Teriyaki",  Dish.DishEnum.L, 10.0);

        Assertions.assertEquals(dish1.name, "30cm Teriyaki");
        Assertions.assertEquals(dish1.size, "30cm Teriyaki");

    }
}
