package tp2;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {

        DeliveryPlatform uberEat = new DeliveryPlatform();


        Restaurant McDo = new Restaurant("McDo");
        Restaurant KFC = new Restaurant("KFC");


        uberEat.subscribeRestaurant(McDo);
        uberEat.subscribeRestaurant(KFC);


        Dish BigMac = new Dish("BigMac", Dish.Taille.S);
        Dish Fries = new Dish("Fries", Dish.Taille.M);
        Dish Zinger = new Dish("Zinger", Dish.Taille.L);


        HashMap<Dish, Integer> McDoOrder = new HashMap<>();
        McDoOrder.put(BigMac, 2);
        McDoOrder.put(Fries, 3);


        HashMap<Dish, Integer> KFCOrder = new HashMap<>();
        KFCOrder.put(Zinger, 1);


        new Thread(() -> McDo.prepareOrder(McDoOrder, 25.65, "45 Rue du port")).start();
        new Thread(() -> KFC.prepareOrder(KFCOrder, 18.50, "12 Avenue des Champs")).start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        uberEat.shutdown();
    }
}
