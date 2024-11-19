package fr.baretto.tp3;

public interface Subscriber {
    void handleEvent(Order order) throws InterruptedException;
}