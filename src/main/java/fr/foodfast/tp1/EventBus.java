package fr.foodfast.tp1;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private List<Subscriber> subscribers;

    bon

    // Constructeur
    public EventBus() {
        this.subscribers = new ArrayList<>();
    }

    // Getter pour la liste des abonnés
    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    // Setter pour la liste des abonnés
    public void setSubscribers(List<Subscriber> subscribers) {
        if (subscribers != null) {
            this.subscribers = subscribers;
        } else {
            throw new IllegalArgumentException("La liste des abonnés ne peut pas être null.");
        }
    }

    // Méthode pour ajouter un abonné
    public void subscribe(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    // Méthode pour notifier tous les abonnés d'un événement
    public void notifySubscribers(Order order) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(order);
        }
    }
}
