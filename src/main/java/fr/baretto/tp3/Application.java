package fr.baretto.tp3;

import fr.baretto.tp3.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException, OrderPreparationException, SQLException {

        Connection connection = DatabaseConnection.getConnection();

        connection.prepareStatement("CREATE TABLE IF NOT EXISTS events(id UUID PRIMARY KEY, type VARCHAR(255), date VARCHAR(255))").execute();

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

        PreparedStatement query = connection.prepareStatement("Select * from events where type = 'Order'");
        ResultSet rst = query.executeQuery();
        while(rst.next()){
            PreparedStatement statement = connection.prepareStatement("UPDATE events SET type = ?, date = ? WHERE id = ?");
            statement.setObject(3,  rst.getObject("id"));
            statement.setString(1, "Delivery");
            statement.setString(2, "" + new Date().getTime());
            statement.execute();
        }
    }
}
