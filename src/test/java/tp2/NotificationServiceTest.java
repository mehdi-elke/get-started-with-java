package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {
    @Test
    public void testSendNotification() {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("Test notification");

    }
}
