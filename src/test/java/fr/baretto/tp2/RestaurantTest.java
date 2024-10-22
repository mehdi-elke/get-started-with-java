package fr.baretto.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTest {

    @Test
    public void testPrepareOrder() throws InterruptedException {

        Restaurant restaurant = new Restaurant("Test Restaurant");

        Dish pizza = new Dish("Pizza", DishSize.L);
        Dish burger = new Dish("Burger", DishSize.M);
        Dish salad = new Dish("Salad", DishSize.S);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(pizza);
        dishes.add(burger);
        dishes.add(salad);
        dishes.add(pizza);

        double expectedPrice = 45.0;
        String expectedDeliveryPlace = "123 Main St";

        Order order = restaurant.prepareOrder(dishes, expectedPrice, expectedDeliveryPlace);

        assertNotNull(order);

        assertEquals("Test Restaurant", order.getRestaurant().getName());

        assertEquals(expectedPrice, order.getPrice());

        assertEquals(expectedDeliveryPlace, order.getDeliveryPlace());

        assertEquals(3, order.getDishes().size());
        assertEquals(2, order.getDishes().get(pizza));
        assertEquals(1, order.getDishes().get(burger));
        assertEquals(1, order.getDishes().get(salad));
    }
}
