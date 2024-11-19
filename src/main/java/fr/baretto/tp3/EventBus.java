package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private List<Subscriber> subscribers;

    public EventBus() {
        subscribers = new ArrayList<>();
    }

    public void handleEvent(Order order) {
        subscribers.forEach(subscriber -> {
            try {
                subscriber.handleEvent(order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}