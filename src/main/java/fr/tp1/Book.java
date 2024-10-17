package fr.tp1;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int year_published;
    private Double price;
    private int pourcentage;

    public Book(String title, String author, int year_published, Double price) {
        this.title = title;
        this.author = author;
        this.year_published = year_published;
        this.price = price;
    }

    public int getYear() {
        return year_published;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.title.toLowerCase(), ((Book) obj).title.toLowerCase())
                && Objects.equals(this.author.toLowerCase(), ((Book) obj).author.toLowerCase());
    }

    @Override
    public String toString() {
        return "Book %s\nAuthor %s\nYear %d\nPrice %.2f\n".formatted(title, author, year_published, price);
    }

    public void applyDiscount(int pourcentage) {
        this.price = this.price * (1 - pourcentage / 100.0);
    }

    public Book plusRecent(Book livre, Book livre2){
        return (livre.getYear() > livre2.getYear()) ? livre : livre2;
    }
}