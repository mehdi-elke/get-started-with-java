package fr.tp2;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Restaurant {
    private final String name;
    private final Set<String> orderIds = new HashSet<>();
    private boolean isTest = false;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, boolean isTest) {
        this(name);
        this.isTest = isTest;
    }

    public String getName() {
        return name;
    }


    public void prepareOrder(Order order) throws Throwable {
        order.setStatus(OrderStatus.PREPARING);

        if (isTest && new Random().nextInt(5) == 3) {
            throw new DeliveryProcessingException("Error while preparing order");
        }
        Thread.sleep(new Random().nextInt(1000) + 1000);
        order.setStatus(OrderStatus.READY_FOR_DELIVERY);

        Thread.sleep(new Random().nextInt(13000) + 2000);
        order.setStatus(OrderStatus.DELIVERED);


    }
}