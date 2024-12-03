package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DishTest {
    @Test
    public void testDishCreation() {
        Dish dish = new Dish("Burger", Dish.Size.M);
        assertEquals("Burger", dish.getName());
        assertEquals(Dish.Size.M, dish.getSize());
    }

    @Test
    public void testSetName() {
        Dish dish = new Dish("Burger", Dish.Size.M);
        dish.setName("Pizza");
        assertEquals("Pizza", dish.getName());
    }

    @Test
    public void testSetSize() {
        Dish dish = new Dish("Burger", Dish.Size.M);
        dish.setSize(Dish.Size.L);
        assertEquals(Dish.Size.L, dish.getSize());
    }
}