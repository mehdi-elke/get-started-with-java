package Tp2;

public class Order
{
    private Restaurant resto;
    private Dish dish;
    private int quantity;
    private int price;
    private String adresse;
    public Order(Restaurant restaurant, Dish dish, int quantity, int price, String adresse){
        this.resto = restaurant;
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
        this.adresse = adresse;
    }
}
