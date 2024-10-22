package Tp2;

import java.security.PublicKey;
import java.util.Random;

public class Restaurant {

    private final String name;
    private Watcher deliveryPlateform;
    public Restaurant(String name) {this.name = name;}
    public Order prepareOrder(Dish dish, int quantity, int price, String address) {

        Order nOrder =  new Order(this, dish, quantity, price, address);
        if (deliveryPlateform != null) {deliveryPlateform.update(nOrder);}
        return nOrder;
    }
    public void setWatcher(Watcher watcher) {
        this.deliveryPlateform = watcher;
    }
    public String getName() {return name;}
}
