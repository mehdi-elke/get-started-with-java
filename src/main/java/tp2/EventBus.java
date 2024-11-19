package tp2;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
    private final Set<Subscriber> subscribers = new HashSet<>();

    // Méthode pour ajouter un Subscriber
    public void subscribe(Subscriber subscriber) {
        synchronized (subscribers) {
            subscribers.add(subscriber);
        }
    }

    // Méthode pour notifier tous les abonnés d'un événement
    public void publishEvent(Order order) {
        synchronized (subscribers) {
            for (Subscriber subscriber : subscribers) {
                subscriber.handleEvent(order);
            }
        }
    }
}
