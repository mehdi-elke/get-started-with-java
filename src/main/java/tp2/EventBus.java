package tp2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(event);
        }
        saveEventToDatabase(event);
    }

    private void saveEventToDatabase(Event event) {
        String sql = "INSERT INTO events (id, type, event_timestamp, details) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, event.getId(), java.sql.Types.OTHER);
            statement.setString(2, event.getType().name());
            statement.setObject(3, LocalDateTime.now());
            statement.setString(4, event.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}