package Tp2;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

public class DeliveryPlateform implements Subcriber {
    private final String plateform;
    Set<Order> setorder = new HashSet<>();
    public DeliveryPlateform(String plateform) {this.plateform = plateform;}
    public String getPlateform() {return plateform;}
    public void delivery(Order order) {
        Logger.getInstance().logEvent("Delivery: " + order.getDish().getName() + " From " + order.getResto().getName()+" To " + order.getAdresse());
    }
//    @Override
//    public void update(Object o) {
//        if (o instanceof Order) {
//            Order order = (Order) o;
//            boolean verif = false;
//            for (Order order2 : setorder) {
//                if(order.equals(order2)) {
//                    verif = true;
//                }
//            };
//            if (setorder.add(order)) {
//                if (!verif) {delivery(order);}
//            }
//
//        }
//    }


    @Override
    public void sub() {
        EventBus.getInstance().subscribe(EventType.DELIVERY, this);
    }

    public void handleEvent(Event order) {
        if (order instanceof DeliveryEvent) {
            DeliveryEvent orderEvent = (DeliveryEvent) order;
            DeliveryPlateform order1 = orderEvent.getPayload();
            if (order1.equals(this)) {
                this.delivery(orderEvent.ord);
            }
            else {
                return;
            }
        }
    }

    public String getDeliveryOutput() {
        return "Delivery: " + setorder.iterator().next().getDish().getName() + " From " + setorder.iterator().next().getResto().getName()+" To " + setorder.iterator().next().getAdresse();
    }
}
