package fr.baretto.tp2;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
    private final Set<Subscriber> subscribers;

    public EventBus() {
        subscribers = new HashSet<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publishEvent(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(event);
        }
    }
}
