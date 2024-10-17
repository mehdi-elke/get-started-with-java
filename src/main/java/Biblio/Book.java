package Biblio;

public class Book {
    private String title;
    private String author;

    private String price;
    private int yearPublished;

    public Book(String title, String author, int yearPublished, String price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return yearPublished == book.yearPublished && title.equals(book.title) && author.equals(book.author) && price.equals(book.price);
    }
}
