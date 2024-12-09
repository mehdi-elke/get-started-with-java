package fr.baretto.tp2;

public interface Observer {
    public void update(String event, Order order) throws InterruptedException;
}
