package tp2;

import java.util.HashMap;

public class Application {

    public static void  main(String[] args){
        DeliveryPlatform uberEat = new DeliveryPlatform();
        Restaurant McDo = new Restaurant("McDo");
        Dish BigMac = new Dish("BigMac", Dish.Taille.S);
        Dish Fries = new Dish("McFries", Dish.Taille.M);

        HashMap<Dish, Integer> Order1 = new HashMap<>();
        Order1.put(BigMac, 3);
        Order1.put(Fries, 2);

        McDo.prepareOrder(Order1, 25.65, "45 Rue du port");
        
    }


}
