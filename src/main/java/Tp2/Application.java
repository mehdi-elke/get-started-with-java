package Tp2;

public class Application {
    public static void main(String[] args) {

        System.out.println("Bienvenue sur DeliveryWorld");
        DeliveryPlateform UberEat = new DeliveryPlateform("UberEat");
        Restaurant Macdonald = new Restaurant("MacDonald");
        Macdonald.sub();
        UberEat.sub();
        Macdonald.addDeliveryPlateform(UberEat);
        Dish BigMac = new Dish("BigMac",Height.L);
        Order order = new Order(Macdonald, BigMac, 2, 10, "Paris");
        order.publish();

    }
}
