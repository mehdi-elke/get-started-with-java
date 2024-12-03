package fr.tp2;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBus {
    public static final Set<Subscriber> subscribers = new HashSet<>();
    private final ExecutorService service = Executors.newCachedThreadPool();


    public static void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static void handleEvent(EventType type, Subscribable $object) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Event event = type.getEventClass().getDeclaredConstructor(Subscribable.class).newInstance($object);
        try {
            for (Subscriber subscriber : subscribers) {
                if (!subscriber.getSuscribedEvents().contains(event.getClass())) {
                    return;
                }
                String methodName = "handle" + event.getClass().getSimpleName();
                try {
                    subscriber.getClass().getMethod(methodName, Event.class).invoke(subscriber, event);
                } catch (NoSuchMethodException e) {
                    System.out.println("No method found for " + methodName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

