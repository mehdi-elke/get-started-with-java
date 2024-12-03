package tp2;
import java.util.UUID;

public class Invoice {
    public enum Status {
        CREATED, CLOSED
    }

    private UUID id;
    private Order order;
    private Status status;

    public Invoice(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
        this.status = Status.CREATED;
    }

    public UUID getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", order=" + order +
                ", status=" + status +
                '}';
    }
}