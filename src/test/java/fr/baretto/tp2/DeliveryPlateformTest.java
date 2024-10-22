package fr.baretto.tp2;

public class DeliveryPlateformTest {

    public void deliverOrder(Order order) {
        String msg = "Votre commande de " + order.getQuantity() + " " + order.getDish().getName() + " a été livrée à cette adresse: " + order.getAddress();
        msg += " pour un montant de " + order.getInitialPrice() * order.getQuantity() + "€";
        System.out.println(msg);
    }

    @Test
    public void notNullOrder() { Assertions.assertNotNull(Order order); }

    @Test
    public void notNullRestaurant() { Assertions.assertNotNull(Restaurant restaurant); }

    @Test
    public void notNullDish() { Assertions.assertNotNull(Dish dish); }

    @Test
    public void isOrderType() { Assertions.assertTrue(order instanceof Order); }

}
