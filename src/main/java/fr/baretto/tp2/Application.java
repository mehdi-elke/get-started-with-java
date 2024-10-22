package fr.baretto.tp2;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Le Wagon");
        Restaurant restaurant2 = new Restaurant("O'Tacos");

        DeliveryPlateform deliveryPlateform = new DeliveryPlateform();

        restaurant1.addObserver(deliveryPlateform);
        restaurant2.addObserver(deliveryPlateform);

        Order order1 = restaurant1.prepareOrder(new Dish("Tacos", 8.0), 4, 11.0, "28 rue d'inkermann");
        Order order2 = restaurant1.prepareOrder(new Dish("Pizza", 8.0), 1, 15.0, "81 rue d'inkermann, Roubaix");
        Order order3 = restaurant2.prepareOrder(new Dish("Burger", 5.5), 10, 5.5, "43 rue du jardin des plantes");

        deliveryPlateform.subscribe(restaurant1);
        deliveryPlateform.subscribe(restaurant2);
    }
}
