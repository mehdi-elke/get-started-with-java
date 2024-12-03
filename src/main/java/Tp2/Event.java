package Tp2;

import java.util.UUID;

public interface Event {
    public UUID getId();
    public EventType getType();
    public Object getPayload();
    public void setPayload(Object o);
}
