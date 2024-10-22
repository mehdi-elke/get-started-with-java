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
    public Restaurant getResto(){return resto;}
    public Dish getDish(){return dish;}
    public int getQuantity(){return quantity;}
    public int getPrice(){return price;}
    public String getAdresse(){return adresse;}
    public boolean equals(Order o){
        return this.adresse.equals(o.getAdresse()) && this.dish.equals(o.getDish()) && this.quantity == o.getQuantity();
    }
}
