package fr.baretto;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int yearPublished = 0;
    private double price = 0;

    public Book(String title, String author, int yearPublished, int price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public double applyDiscount(double discountPercentage) {
        this.price *= discountPercentage;
        return this.price;
    }

    public Book compareYearPublished(Book other) {
        if (this.yearPublished >= other.yearPublished) {
            return this;
        } else {
            return other;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
