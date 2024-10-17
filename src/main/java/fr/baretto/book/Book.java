package fr.baretto.book;

public class Book {
    private String title;
    private String author;
    private int yearPublish;
    private double price;

    public Book(String title, String author, int yearPublish, double price) {
        this.title = title;
        this.author = author;
        this.yearPublish = yearPublish;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this.title.equals(book.title) && this.author.equals(book.author);
    }

    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", yearPublish=" + yearPublish + ", price=" + price + "]";
    }

    public double applyDiscount(double discount) {
        return price - price * discount / 100;
    }

    public int compareYearBook(Book book) {
        return this.yearPublish - book.yearPublish;
    }
}
