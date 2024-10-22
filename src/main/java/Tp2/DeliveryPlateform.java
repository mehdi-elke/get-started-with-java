package Tp2;
import java.util.HashSet;
import java.util.Set;
public class DeliveryPlateform implements Watcher{
    private final String plateform;
    Set<Order> setorder = new HashSet<>();
    public DeliveryPlateform(String plateform) {this.plateform = plateform;}
    public String getPlateform() {return plateform;}
    public void delivery(Order order) {
        System.out.println("Delivery: " + order.getDish().getName() + " From " + order.getResto().getName()+" To " + order.getAdresse() );
    }

    @Override
    public void update(Object o) {
        if (o instanceof Order) {
            Order order = (Order) o;
            boolean verif = false;
            for (Order order2 : setorder) {
                if(order.equals(order2)) {
                    verif = true;
                }
            };
            if (setorder.add(order)) {
                if (!verif) {delivery(order);}
            }

        }
    }

    public String getDeliveryOutput() {
        return "Delivery: " + setorder.iterator().next().getDish().getName() + " From " + setorder.iterator().next().getResto().getName()+" To " + setorder.iterator().next().getAdresse();
    }
}
