package fr.baretto.tp2;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
    private final Set<Subscriber> subscribers;

    public EventBus() {
        subscribers = new HashSet<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber); // Ajout d'un subscriber unique
    }

    public void publishEvent(Order order) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(order); // Notifie chaque subscriber
        }
    }

    public int getSubscriberCount() {
        return subscribers.size();
    }

    public boolean containsSubscriber(Subscriber subscriber) {
        return subscribers.contains(subscriber);
    }
}