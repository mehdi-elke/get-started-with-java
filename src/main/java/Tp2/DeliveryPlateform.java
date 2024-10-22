package Tp2;

public class DeliveryPlateform implements Watcher{
    private final String plateform;
    public DeliveryPlateform(String plateform) {this.plateform = plateform;}
    public String getPlateform() {return plateform;}
    public void delivery(Order order) {
        System.out.println("Delivery: " + order.getDish().getName() + " From " + order.getResto().getName()+" To " + order.getAdresse() );
    }

    @Override
    public void update(Object o) {
        if (o instanceof Order) {
            Order order = (Order) o;
            delivery(order);
        }
    }
}
