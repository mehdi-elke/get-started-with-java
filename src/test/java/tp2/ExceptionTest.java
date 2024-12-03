package tp2;

import fr.tp2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    private DeliveryPlatform platform;
    private Restaurant mcDonalds;
    private Restaurant subway;
    private Restaurant burgerKing;

    @BeforeEach
    public void setUp() {
        platform = new DeliveryPlatform();
        mcDonalds = new Restaurant("McDonald's");
        subway = new Restaurant("Subway");
        burgerKing = new Restaurant("Burger King", true);

        platform.addRestaurant(mcDonalds);
        platform.addRestaurant(subway);
        platform.addRestaurant(burgerKing);

        EventBus.subscribe(platform);

    }

    @Test
    public void testException() {
        try {

            Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
            Dish sub30Teriyaki = new Dish("30cm Teriyaki", Dish.DishEnum.L, 10.0);

            ListDishes listDishes1 = new ListDishes();
            listDishes1.addDish(bigMac, 1);
            String uuidVar = UUID.randomUUID().toString();
            Order order1 = new Order(mcDonalds, listDishes1.getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE, uuidVar);

            ListDishes listDishes2 = new ListDishes();
            listDishes2.addDish(sub30Teriyaki, 1);
            Order order2 = new Order(subway, listDishes2.getDishes(), "5 rue de Paris", OrderStatus.TO_PREPARE, uuidVar);

            mcDonalds.prepareOrder(order1);
            subway.prepareOrder(order2);

        }catch (Throwable e) {
            if (e instanceof DeliveryProcessingException) {
                ErrorManagementService.logError((Exception) e);
            } else if (e instanceof OrderPreparationException) {
                ErrorManagementService.logError((Exception) e);
            }
        }
        assertFalse(ErrorManagementService.isEmpty());
    }

    @Test
    public void test20percent() {
        Dish whopper = new Dish("Whopper", Dish.DishEnum.L, 10.0);
        Dish nuggets = new Dish("Nuggets", Dish.DishEnum.S, 6.0);

        ListDishes listDishes = new ListDishes();
        listDishes.addDish(whopper, 1);
        listDishes.addDish(nuggets, 3);
        try {
            Order order = new Order(burgerKing, listDishes.getDishes(), "3 rue de Paris", OrderStatus.TO_PREPARE);
            burgerKing.prepareOrder(order);
        }catch (Throwable e) {
            if (e instanceof DeliveryProcessingException) {
                ErrorManagementService.logError((Exception) e);
            } else if (e instanceof OrderPreparationException) {
                ErrorManagementService.logError((Exception) e);
            }
        }
        assertFalse(ErrorManagementService.isEmpty());


    }
}
