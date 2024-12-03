package fr.baretto.tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorManagementServiceTest {

    @Test
    public void testLogError() {
        String errorMessage = "Test d'erreur";
        ErrorManagementService.logError(errorMessage);

        assertTrue(ErrorManagementService.getErrorLog().contains(errorMessage));
    }

    @Test
    public void testOrderPreparationError() throws DeliveryProcessingException, OrderPreparationException {
        Restaurant restaurant = new Restaurant("Testaurant");
        Dish dish = new Dish("Burger", 8.0);

        // Ajoutez un client pour le test
        Customer customer = new Customer("John", "Doe", "456 Main St", "0612345678");

        // Mettez à jour l'appel à prepareOrder
        for (int i = 0; i < 10; i++) {
            Order order = restaurant.prepareOrder(dish, 2, 8.0, "Test Address", customer);
            if (order == null) {
                assertFalse(ErrorManagementService.getErrorLog().isEmpty());
            }
        }
    }
}
