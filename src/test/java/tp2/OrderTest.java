package tp2;

import fr.tp2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class OrderTest {

    Restaurant sacha;
    Dish nouilles;
    Dish ramen;

    @BeforeEach
    public void setUp() {
        sacha = new Restaurant("Sacha & co");
        nouilles = new Dish("Nouilles", Dish.DishEnum.L, 10.0);
        ramen = new Dish("Ramen", Dish.DishEnum.S, 14.0);
    }

    @Test
    public void testCreateOrder() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Order order1 = new Order(sacha, (new ListDishes())
                .addDish(nouilles, 1)
                .addDish(ramen, 3)
                .getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        Assertions.assertEquals(ramen.getName(), "Ramen");
        Assertions.assertEquals(ramen.getSize(), Dish.DishEnum.S);
        Assertions.assertEquals(ramen.getPrice(), 14.0);

        Assertions.assertEquals(order1.getTotal(), 52.0);

    }


}
