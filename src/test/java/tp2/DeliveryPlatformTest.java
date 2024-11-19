package tp2;

import fr.tp2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryPlatformTest {

    private DeliveryPlatform platform;
    private Restaurant mcDonalds;
    private Restaurant subway;

    @BeforeEach
    public void setUp() {
        platform = new DeliveryPlatform();
        mcDonalds = new Restaurant("McDonald's");
        subway = new Restaurant("Subway");

        platform.addRestaurant(mcDonalds);
        platform.addRestaurant(subway);
    }

    @Test
    public void testAddRestaurant() {
        assertTrue(platform.getRestaurants().contains(mcDonalds));
        assertTrue(platform.getRestaurants().contains(subway));
    }

    @Test
    public void testDeliveryOrder() throws InterruptedException {
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);

        ListDishes listDishes = new ListDishes();
        listDishes.addDish(bigMac, 1);

        Order order = new Order(mcDonalds, listDishes.getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);
        mcDonalds.prepareOrder(order);
        Thread.sleep(4000);

        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    public void testOrderPriority() throws InterruptedException {
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Dish sub30Terryaki = new Dish("30cm Teriyaki", Dish.DishEnum.L, 10.0);

        ListDishes listDishes1 = new ListDishes();
        listDishes1.addDish(bigMac, 1);
        Order order1 = new Order(mcDonalds, listDishes1.getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);
        order1.uuid = UUID.randomUUID().toString();

        ListDishes listDishes2 = new ListDishes();
        listDishes2.addDish(sub30Terryaki, 1);
        Order order2 = new Order(subway, listDishes2.getDishes(), "5 rue de Paris", OrderStatus.TO_PREPARE);
        order2.uuid = UUID.randomUUID().toString();

        mcDonalds.prepareOrder(order1);
        subway.prepareOrder(order2);
        Thread.sleep(4000);

        assertEquals(OrderStatus.DELIVERED, order1.getStatus());
        assertEquals(OrderStatus.DELIVERED, order2.getStatus());
    }

    @Test
    public void testIsOrderDuplicate() throws InterruptedException {
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Dish sub30Terryaki = new Dish("30cm Teriyaki", Dish.DishEnum.L, 10.0);

        ListDishes listDishes1 = new ListDishes();
        listDishes1.addDish(bigMac, 1);
        Order order1 = new Order(mcDonalds, listDishes1.getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);
        String uuidVar = UUID.randomUUID().toString();

        order1.uuid = uuidVar;

        ListDishes listDishes2 = new ListDishes();
        listDishes2.addDish(sub30Terryaki, 1);
        Order order2 = new Order(subway, listDishes2.getDishes(), "5 rue de Paris", OrderStatus.TO_PREPARE);
        order2.uuid = uuidVar;

        mcDonalds.prepareOrder(order1);
        subway.prepareOrder(order2);
        Thread.sleep(4000);

        assertEquals(OrderStatus.DELIVERED, order1.getStatus());
        assertEquals(OrderStatus.IN_ERROR, order2.getStatus());
    }
}