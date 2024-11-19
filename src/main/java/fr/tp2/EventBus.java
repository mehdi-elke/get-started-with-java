package fr.tp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBus {
    public static final Set<Subscriber> subscribers = new HashSet<>();
    private final ExecutorService service = Executors.newCachedThreadPool();


    public static void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static void handleEvent(Order order) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(order);
        }
    }
}

