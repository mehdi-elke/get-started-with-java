package fr.baretto.tp3;

import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException, OrderPreparationException {
        EventBus eventBus = new EventBus();

        Restaurant restaurant = new Restaurant("FoodFast", eventBus);
        Restaurant restaurant2 = new Restaurant("FoodFast2", eventBus);

        Customer customer = new Customer("Doe", "John", "123 rue de la paix", "06 12 34 56 78");
        Customer customer2 = new Customer("Dupont", "Paul", "123 rue de la paix", "06 12 34 56 78");

        DeliveryPlateform foodFastLivraison = new DeliveryPlateform(eventBus);

        eventBus.subscribe(foodFastLivraison, EventType.ORDER_PREPARED);
        eventBus.subscribe(restaurant, EventType.DELIVERY);
        eventBus.subscribe(restaurant2, EventType.DELIVERY);


        Dish pates = new Dish("pâtes", DishSize.M);
        Dish lasagnes = new Dish("lasagnes", DishSize.L);
        Dish pizza = new Dish("pizza", DishSize.S);



        restaurant.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille", customer);
        restaurant.prepareOrder(List.of(pates, pizza), 30, "Lille", customer);
        restaurant.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille", customer);
        restaurant2.prepareOrder(List.of(pates, lasagnes, pizza), 30, "Lille", customer2);

        System.out.println(ErrorManagementService.exceptions);
    }
}
