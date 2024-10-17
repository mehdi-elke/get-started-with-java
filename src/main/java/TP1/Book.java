package TP1;

public class Book {
    private String title;
    private String author;
    private int yearPublished = 0;
    private int price = 0;
    public Book(String title, String author, int price,int yearPublished) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;

    }
    public boolean equal(Book b) {
        return this.title.equals(b.title) && this.author.equals(b.author);
    }
    public String toString() {
        return title + "\t" + author + "\t" + yearPublished + "\t" + price;
    }
    public String applyDiscount(int percentage) {
        return this.price - (this.price * percentage / 100) + "e";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getPrice() {
        return price;
    }
    public Book compareYear(Book b) {
        if (this.yearPublished > b.getYearPublished()){
            return this;
        }
        else {
            return b;
        }
    }
}
