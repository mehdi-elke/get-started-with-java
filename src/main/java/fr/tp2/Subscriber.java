package fr.tp2;

import java.util.List;

public abstract class Subscriber implements SubscriberInterface {
    public List<Class<? extends Event>> getSuscribedEvents() {
        return null;
    }
}
