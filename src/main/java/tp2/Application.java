package tp2;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        // Create the delivery platform
        DeliveryPlatform uberEat = new DeliveryPlatform();

        // Create restaurants
        Restaurant McDo = new Restaurant("McDo");
        Restaurant KFC = new Restaurant("KFC");

        // Subscribe restaurants to the platform
        uberEat.subscribeRestaurant(McDo);
        uberEat.subscribeRestaurant(KFC);

        // Create dishes
        Dish BigMac = new Dish("BigMac", Dish.Taille.S);
        Dish Fries = new Dish("Fries", Dish.Taille.M);
        Dish Zinger = new Dish("Zinger", Dish.Taille.L);

        // Create orders for McDo
        HashMap<Dish, Integer> McDoOrder1 = new HashMap<>();
        McDoOrder1.put(BigMac, 2);
        McDoOrder1.put(Fries, 3);

        // Create a duplicate order for McDo
        HashMap<Dish, Integer> McDoOrderDuplicate = new HashMap<>();
        McDoOrderDuplicate.put(BigMac, 2);
        McDoOrderDuplicate.put(Fries, 3);

        // Create an order for KFC
        HashMap<Dish, Integer> KFCOrder = new HashMap<>();
        KFCOrder.put(Zinger, 1);

        // Prepare and notify orders concurrently
        Order order1 = McDo.prepareOrder(McDoOrder1, 25.65, "45 Rue du port");
        Order duplicateOrder = new Order(order1.getRestaurant(), order1.getDishes(), order1.getPrice(), order1.getDeliveryLocation()); // Intentional duplicate
        Order order2 = KFC.prepareOrder(KFCOrder, 18.50, "12 Avenue des Champs");

        // Notify the platform about these orders
        uberEat.update(order1);
        uberEat.update(duplicateOrder); // This should be detected as a duplicate
        uberEat.update(order2);

        // Allow time for processing
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the platform
        uberEat.shutdown();
    }
}
