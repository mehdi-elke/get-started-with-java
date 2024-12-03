package tp2;

import java.util.UUID;

public interface Event {
    UUID getId();
    EventType getType();
    String toString();
}