package fr.tp2;

public enum EventType {
    ORDER(OrderEvent.class),
    DELIVERY(DeliveryEvent.class);

    private final Class<? extends Event> eventClass;

    EventType(Class<? extends Event> eventClass) {
        this.eventClass = eventClass;
    }

    public Class<? extends Event> getEventClass() {
        return eventClass;
    }
}
