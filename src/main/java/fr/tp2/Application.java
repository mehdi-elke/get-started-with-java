package fr.tp2;

public class Application {
    public static void main(String[] args) throws Exception {
        Restaurant mcDonalds = new Restaurant("McDonald's");
        Restaurant subway = new Restaurant("Subway");

        DeliveryPlatform observer = new DeliveryPlatform();
        observer.addRestaurant(mcDonalds);
        observer.addRestaurant(subway);

        EventBus.subscribe(observer);

        Dish sub30Teriyaki = new Dish("30cm Teriyaki",  Dish.DishEnum.L, 10.0);
        Dish sub15bmt = new Dish("15cm BMT",  Dish.DishEnum.M, 5.0);
        Dish bigMac = new Dish("Big Mac", Dish.DishEnum.L, 8.0);
        Dish mcNuggets = new Dish("McNuggets", Dish.DishEnum.S, 6.0);

        Order order1 = new Order(mcDonalds, (new ListDishes())
                .addDish(bigMac, 1)
                .addDish(mcNuggets, 3)
                .getDishes(), "2 rue de Paris", OrderStatus.TO_PREPARE);

        Order order2 = new Order(subway, (new ListDishes())
                .addDish(sub30Teriyaki, 1)
                .addDish(sub15bmt, 2)
                .getDishes(), "5 rue de Paris", OrderStatus.TO_PREPARE);

        mcDonalds.prepareOrder(order1);
        subway.prepareOrder(order2);
    }
}