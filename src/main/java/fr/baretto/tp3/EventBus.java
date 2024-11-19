package fr.baretto.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {

    private Map<EventType, List<Subscriber>> subscribers;

    public EventBus() {
        subscribers = new HashMap<>();
    }

    public void handleEvent(EventType eventType, Event event) {
        subscribers.getOrDefault(eventType, List.of()).forEach(
                subscriber -> {
                    try {
                        subscriber.handleEvent(event);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void subscribe(Subscriber subscriber, EventType eventType) {
        var list = subscribers.getOrDefault(eventType, new ArrayList<>());
        list.add(subscriber);
        subscribers.put(eventType, list);
    }
}