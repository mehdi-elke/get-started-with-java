package fr.baretto.tp2;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Le Wagon");
        DeliveryPlateform deliveryPlateform = new DeliveryPlateform();
        Order order1 = restaurant.prepareOrder(new Dish("Tacos"), 4, 11, "28 rue d'inkermann");
        Order order2 = restaurant.prepareOrder(new Dish("Pizza"), 1, 15, "81 rue d'inkermann roubaix");
        Order order3 = restaurant.prepareOrder(new Dish("Burger"), 10, 5.5, "43 rue du jardin des plantes");
        deliveryPlateform.deliverOrder(order1);
        deliveryPlateform.deliverOrder(order2);
        deliveryPlateform.deliverOrder(order3);
    }
}
