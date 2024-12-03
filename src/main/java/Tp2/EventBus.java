package Tp2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EventBus {
    private final Set<Subcriber> subscribers;

    public EventBus() {
        subscribers = new HashSet<>();
    }

    public void subscribe(Subcriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(Order order ) {
        for (Subcriber subscriber : subscribers) {
            subscriber.handleEvent(order);
        }
    }

    public int getSubscribersSize() {
        return subscribers.size();
    }

    public boolean isSubscribed(Subcriber subscriber) {
        return subscribers.contains(subscriber);
    }
}
