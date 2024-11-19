package fr.baretto.tp3;

public interface Subscriber {
    void handleEvent(Event event) throws InterruptedException;
}