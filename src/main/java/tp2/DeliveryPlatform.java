package tp2;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class DeliveryPlatform implements Subscriber {
    private Set<Order> orders = new HashSet<>();
    private ErrorManagementService errorService;
    private Logger logger = Logger.getInstance();
    private NotificationService notificationService = new NotificationService();
    private BillingService billingService = new BillingService();

    public DeliveryPlatform(ErrorManagementService errorService) {
        this.errorService = errorService;
    }

    public void deliver(Order order) throws DeliveryProcessingException {
        if (order.getStatus() == Order.Status.CANCELLED) {
            logger.log("Order is cancelled and cannot be delivered: " + order.getId());
            return;
        }

        if (new Random().nextInt(100) < 20) { // 20% chance of failure
            throw new DeliveryProcessingException("Failed to deliver order: " + order.getId());
        }
        if (orders.add(order)) {
            logger.log("Delivering order: " + order.getId());
            notificationService.sendNotification("Your order " + order.getId() + " is being delivered to " + order.getCustomer().getDeliveryAddress());
            Invoice invoice = billingService.createInvoice(order);
            // Simulate delivery completion
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(13000) + 2000); // Simulate delivery time between 2 and 15 seconds
                    completeDelivery(order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            logger.log("Duplicate order detected: " + order.getId());
        }
    }

    public void completeDelivery(Order order) {
        if (order.getStatus() == Order.Status.CANCELLED) {
            logger.log("Order is cancelled and cannot be completed: " + order.getId());
            return;
        }

        Invoice invoice = billingService.getInvoice(order.getId());
        if (invoice != null) {
            billingService.closeInvoice(order.getId());
            order.setStatus(Order.Status.COMPLETED);
            logger.log("Order delivered: " + order.getId());
            notificationService.sendNotification("Your order " + order.getId() + " has been delivered.");
        }
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            order.setStatus(Order.Status.CANCELLED);
            logger.log("Order cancelled: " + order.getId());
            notificationService.sendNotification("Your order " + order.getId() + " has been cancelled.");
        }
    }

    public void notifyOrder(Order order) {
        try {
            deliver(order);
        } catch (DeliveryProcessingException e) {
            errorService.logError(e.getMessage());
        }
    }

    @Override
    public void handleEvent(Event event) {
        if (event instanceof OrderEvent) {
            OrderEvent orderEvent = (OrderEvent) event;
            try {
                deliver(orderEvent.getOrder());
                notificationService.sendNotification("Your order " + orderEvent.getOrder().getId() + " is being prepared.");
            } catch (DeliveryProcessingException e) {
                errorService.logError(e.getMessage());
            }
        } else if (event instanceof DeliveryEvent) {
            DeliveryEvent deliveryEvent = (DeliveryEvent) event;
            logger.log("Delivery status: " + deliveryEvent.getStatus() + " for order: " + deliveryEvent.getOrder().getId());
            notificationService.sendNotification("Your order " + deliveryEvent.getOrder().getId() + " is " + deliveryEvent.getStatus() + ".");
        }
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public BillingService getBillingService() {
        return billingService;
    }
}