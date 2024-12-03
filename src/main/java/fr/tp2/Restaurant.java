package fr.tp2;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Restaurant {
    private final String name;
    private final Set<String> orderIds = new HashSet<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void prepareOrder(Order order) throws Exception {
        order.setStatus(OrderStatus.PREPARING);

        Thread.sleep(new Random().nextInt(1000) + 1000);
        order.setStatus(OrderStatus.READY_FOR_DELIVERY);

        Thread.sleep(new Random().nextInt(13000) + 2000);
        order.setStatus(OrderStatus.DELIVERED);


    }
}