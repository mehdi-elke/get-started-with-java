package Tp2;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Flow;

public class DeliveryPlateform implements Subcriber {
    private final String plateform;
    Set<Order> setorder = new HashSet<>();
    public DeliveryPlateform(String plateform) {this.plateform = plateform;}
    public String getPlateform() {return plateform;}
    private static final Random RANDOM = new Random();
    public void delivery(Order order) throws DeliveryProcessingException {
        System.out.println("Delivery: " + order.getDish().getName() + " From " + order.getResto().getName()+" To " + order.getAdresse() );

        if (RANDOM.nextDouble() < 0.2) {
            throw new DeliveryProcessingException("Delivery failed");
        }
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
                try {
                    this.delivery(orderEvent.ord);
                } catch (DeliveryProcessingException e) {
                    e.printStackTrace();
                }
            }
            else {
                return;
            }
        }
    }

    public int getSetOrderSize() {
        return setorder.size();
    }

    public String getDeliveryOutput() {
        return "Delivery: " + setorder.iterator().next().getDish().getName() + " From " + setorder.iterator().next().getResto().getName()+" To " + setorder.iterator().next().getAdresse();
    }
}
