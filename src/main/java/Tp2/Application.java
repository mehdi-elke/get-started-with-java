package Tp2;

public class Application {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur DeliveryWorld");
        DeliveryPlateform UberEat = new DeliveryPlateform("UberEat");
        Restaurant Macdonald = new Restaurant("MacDonald");
        Macdonald.setWatcher(UberEat);
        Dish BigMac = new Dish("BigMac",Height.L);
        Order order = Macdonald.prepareOrder(BigMac,2,3,"1 rue de paris");
    }
}
