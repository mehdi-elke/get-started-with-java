package fr.tp2;

public abstract class Event {
    private Subscribable object;
    Event(Subscribable object) {
        this.object = object;
    }

    public Subscribable getObject() {
        return object;
    }
}
