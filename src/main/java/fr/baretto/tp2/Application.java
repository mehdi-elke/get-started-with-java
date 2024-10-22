package fr.baretto.tp2;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Le Wagon");
        Restaurant restaurant2 = new Restaurant("O'Tacos");
        DeliveryPlateform deliveryPlateform = new DeliveryPlateform();
        Order order1 = restaurant.prepareOrder(new Dish("Tacos", 8.0), 4, 11, "28 rue d'inkermann");
        Order order2 = restaurant.prepareOrder(new Dish("Pizza", 8.0), 1, 15, "81 rue d'inkermann roubaix");
        Order order3 = restaurant.prepareOrder(new Dish("Burger", 8.0), 10, 5.5, "43 rue du jardin des plantes");
        deliveryPlateform.deliverOrder(order1);
        deliveryPlateform.deliverOrder(order2);
        deliveryPlateform.deliverOrder(order3);

        deliveryPlateform.subscribe(restaurant);
        deliveryPlateform.subscribe(restaurant2);
    }
}
