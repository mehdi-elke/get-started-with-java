package tp2;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BillingService {
    private Map<UUID, Invoice> invoices = new HashMap<>();

    public Invoice createInvoice(Order order) {
        Invoice invoice = new Invoice(order);
        invoices.put(order.getId(), invoice);
        System.out.println("Invoice created: " + invoice);
        return invoice;
    }

    public void closeInvoice(UUID orderId) {
        Invoice invoice = invoices.get(orderId);
        if (invoice != null) {
            invoice.setStatus(Invoice.Status.CLOSED);
            System.out.println("Invoice closed: " + invoice);
        } else {
            System.out.println("Invoice not found: " + orderId);
        }
    }

    public Invoice getInvoice(UUID orderId) {
        return invoices.get(orderId);
    }
}