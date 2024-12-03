package fr.foodfast.tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testPrepareAndNotifyOrders() throws OrderPreparationException {
        DeliveryPlatform livraison = new DeliveryPlatform();

        // Souscription des restaurants
        Restaurant resto1 = livraison.subscribeRestaurant(new Restaurant("Chez l'ancien"));
        Restaurant resto2 = livraison.subscribeRestaurant(new Restaurant("Point Sandwich"));
        Restaurant resto3 = livraison.subscribeRestaurant(new Restaurant("Subway"));

        // Commande test 1
        Order expectedOrder1 = new Order(1, "Chez l'ancien", new Dish("Pizza", Dish.Size.L), 3, 20, "3 rue de la paix, 75010 Paris");
        Order order1 = resto1.prepareOrder(1, resto1.getName(), new Dish("Pizza", Dish.Size.L), 3, 20, "3 rue de la paix, 75010 Paris");
        assertEquals(expectedOrder1, order1, "La commande 1 ne correspond pas à l'attendu");

        // Vérification de la notification lors de la préparation
        // On attend un message qui indique que la commande est en cours de préparation
        assertDoesNotThrow(() -> resto1.notifyOrder(order1, livraison),
                "Une exception inattendue a été levée lors de la notification de la commande préparée");

        // Commande test 2
        Order expectedOrder2 = new Order(2, "Point Sandwich", new Dish("Tacos", Dish.Size.M), 1, 11, "55 boulevard de la république, 75004 Paris");
        Order order2 = resto2.prepareOrder(2, resto2.getName(), new Dish("Tacos", Dish.Size.M), 1, 11, "55 boulevard de la république, 75004 Paris");
        assertEquals(expectedOrder2, order2, "La commande 2 ne correspond pas à l'attendu");

        // Vérification de la notification lors de la préparation
        assertDoesNotThrow(() -> resto2.notifyOrder(order2, livraison),
                "Une exception inattendue a été levée lors de la notification de la commande préparée");

        // Commande test 3
        Order expectedOrder3 = new Order(3, "Subway", new Dish("Kebab", Dish.Size.S), 6, 51, "10 rue des génies, 13001 Marseille");
        Order order3 = resto3.prepareOrder(3, resto3.getName(), new Dish("Kebab", Dish.Size.S), 6, 51, "10 rue des génies, 13001 Marseille");
        assertEquals(expectedOrder3, order3, "La commande 3 ne correspond pas à l'attendu");

        // Vérification de la notification lors de la préparation
        assertDoesNotThrow(() -> resto3.notifyOrder(order3, livraison),
                "Une exception inattendue a été levée lors de la notification de la commande préparée");

        // Test doublon : La commande ne doit pas être notifiée une deuxième fois
        assertDoesNotThrow(() -> resto3.notifyOrder(order3, livraison),
                "Une exception inattendue a été levée lors de la notification de doublon");
    }

    @Test
    void testSubscription() {
        DeliveryPlatform livraison = new DeliveryPlatform();

        // Souscription d'un restaurant
        Restaurant resto = new Restaurant("Chez l'ancien");
        Restaurant subscribedResto = livraison.subscribeRestaurant(resto);

        // Test : vérifier que le restaurant est bien souscrit et que son nom est correct
        assertNotNull(subscribedResto, "Le restaurant souscrit ne doit pas être null");
        assertEquals("Chez l'ancien", subscribedResto.getName(), "Le nom du restaurant souscrit ne correspond pas");
    }
}
