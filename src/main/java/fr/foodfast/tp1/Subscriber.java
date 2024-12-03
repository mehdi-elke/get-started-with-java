package fr.foodfast.tp1;

import fr.foodfast.tp1.event.Event;

public interface Subscriber {
    void handleEvent(Event event);
}
