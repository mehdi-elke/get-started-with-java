package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.List;

public class EventBus implements Subscriber {

    private static List<Subscriber> subscribers;

    public EventBus() {
        EventBus.subscribers = new ArrayList<>();
    }

    @Override
    public void handleEvent(Order order) {

    }

    @Override
    public void subscribe(Subscriber subscriber) {
        EventBus.subscribers.add(subscriber);
    }
}