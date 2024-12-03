package fr.foodfast.tp1.event;

import fr.foodfast.tp1.Subscriber;
import fr.foodfast.tp1.delivery.DeliveryEvent;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private final List<Subscriber> subscribers;

    // Constructor
    public EventBus() {
        this.subscribers = new ArrayList<>();
    }

    // Getter for subscribers
    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    // Method to add a subscriber
    public void subscribe(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    // Notify subscribers for a generic Event
    public void notifySubscribers(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(event); // Now handles all types of Event
        }
    }
    public void notifyDeliveryEvent(DeliveryEvent deliveryEvent) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(deliveryEvent); // Transmet uniquement la commande
        }
    }
}
