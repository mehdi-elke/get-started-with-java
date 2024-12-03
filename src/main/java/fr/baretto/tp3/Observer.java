package fr.baretto.tp3;

public interface Observer {
    public void update(String event, Order order) throws InterruptedException;
}
