package Tp2;

import java.util.*;

public class EventBus {

    private static EventBus SingleInstance = null;
    private Map<EventType, List<Subcriber>> subscribers = new HashMap<>();

    public void subscribe(EventType eventType, Subcriber subscriber) {

        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }
    public static EventBus getInstance() {
        if (SingleInstance == null) {
            SingleInstance = new EventBus();
        }
        return SingleInstance;
    }
    public void publish(Event event ) {
        EventType eventType = event.getType(); // Chaque Event a un type
        List<Subcriber> interestedSubscribers = subscribers.get(eventType);
        if (interestedSubscribers != null) {
            for (Subcriber subscriber : interestedSubscribers) {
                subscriber.handleEvent(event);
            }
        }
    }
    public int getSubscribersSize() {
        return subscribers.size();
    }

    public Map<EventType, List<Subcriber>> getSubscribers() {
        return subscribers;
    }
}




