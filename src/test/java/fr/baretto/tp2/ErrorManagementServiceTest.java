package fr.baretto.tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorManagementServiceTest {

    @Test
    void testLogError() {
        String errorMessage = "Test d'erreur";
        ErrorManagementService.logError(errorMessage);

        assertTrue(ErrorManagementService.getErrorLog().contains(errorMessage));
    }

    @Test
    void testOrderPreparationError() {
        Restaurant restaurant = new Restaurant("Testaurant");
        Dish dish = new Dish("Burger", 8.0);

        for (int i = 0; i < 10; i++) {
            Order order = restaurant.prepareOrder(dish, 2, 8.0, "Test Address");
            if (order == null) {
                assertFalse(ErrorManagementService.getErrorLog().isEmpty());
            }
        }
    }

    @Test
    void testDeliveryError() {
        DeliveryPlateform platform = new DeliveryPlateform();
        Order order = new Order(new Restaurant("Le Gourmet"), new Dish("Pizza", 8.0), 2, 8.0, "123 Test Street");

        for (int i = 0; i < 10; i++) {
            platform.deliverOrder(order);
        }

        assertFalse(ErrorManagementService.getErrorLog().isEmpty());
    }
}
