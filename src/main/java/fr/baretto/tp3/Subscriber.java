package fr.baretto.tp3;

import java.sql.SQLException;

public interface Subscriber {
    void handleEvent(Event event) throws InterruptedException, DeliveryProcessingException, SQLException;
}