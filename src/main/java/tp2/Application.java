package tp2;

import java.util.HashMap;


public class Application {

    public static void main(String[] args) {
        // Create the EventBus
        EventBus eventBus = new EventBus();

        // Create the delivery platform
        DeliveryPlatform uberEat = new DeliveryPlatform(eventBus);

        // Create restaurants
        Restaurant McDo = new Restaurant("McDo", eventBus);
        Restaurant KFC = new Restaurant("KFC", eventBus);

        // Create dishes
        Dish BigMac = new Dish("BigMac", Dish.Taille.S);
        Dish Fries = new Dish("Fries", Dish.Taille.M);
        Dish Zinger = new Dish("Zinger", Dish.Taille.L);

        // Create orders for McDo
        HashMap<Dish, Integer> McDoOrder1 = new HashMap<>();
        McDoOrder1.put(BigMac, 2);
        McDoOrder1.put(Fries, 3);

        // Create an order for KFC
        HashMap<Dish, Integer> KFCOrder = new HashMap<>();
        KFCOrder.put(Zinger, 1);

        // Prepare orders
        McDo.prepareOrder(McDoOrder1, 25.65, "45 Rue du port");
        KFC.prepareOrder(KFCOrder, 18.50, "12 Avenue des Champs");

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
