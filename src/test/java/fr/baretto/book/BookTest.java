package fr.baretto.book;

public class BookTest {
    public void testEquals() {
        Book book1 = new Book("title", "author", 2020, 10.0);
        Book book2 = new Book("title", "author", 2020, 10.0);
        Book book3 = new Book("title", "author", 2020, 20.0);
        Book book4 = new Book("title", "author", 2021, 10.0);
        Book book5 = new Book("title", "author2", 2020, 10.0);
        Book book6 = new Book("title2", "author", 2020, 10.0);
        Book book7 = new Book("title", "author", 2020, 10.0);
        assert book1.equals(book2);
        assert !book1.equals(book3);
        assert !book1.equals(book4);
        assert !book1.equals(book5);
        assert !book1.equals(book6);
        assert book1.equals(book7);
    }

    public String toString() {
        Book book = new Book("title", "author", 2020, 10.0);
        assert book.toString().equals("Book{title='title', author='author', yearPublish=2020, price=10.0}");
        return book.toString();
    }

    public double applyDiscount() {
        Book book = new Book("title", "author", 2020, 10.0);
        book.applyDiscount(10);
        assert book.getPrice() == 9.0;
        return book.getPrice();
    }

    public int compareYearBook() {
        Book book1 = new Book("title", "author", 2020, 10.0);
        Book book2 = new Book("title", "author", 2021, 10.0);
        assert book1.compareYearBook(book2) == -1;
        assert book2.compareYearBook(book1) == 1;
        assert book1.compareYearBook(book1) == 0;
        return book1.compareYearBook(book2);
    }
}
