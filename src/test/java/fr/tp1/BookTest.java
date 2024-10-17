package fr.tp1;

import fr.tp1.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void testEquals() {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997, 10.0);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 1977, 10.0);
        Assertions.assertEquals(book1, book2);
    }

    @Test
    public void testToString() {
        Book book = new Book("Harry Potter", "J.K. Rowling", 1997, 10.0);
        String expected = "Book Harry Potter\nAuthor J.K. Rowling\nYear 1997\nPrice 10,00\n";
        Assertions.assertEquals(expected, book.toString());
    }

    @Test
    public void testApplyDiscount() {
        Book book = new Book("Harry Potter", "J.K. Rowling", 1997, 100.0);
        book.applyDiscount(10);
        Assertions.assertEquals(90.0, book.getPrice());
    }

    @Test
    public void testPlusRecent() {
        Book book1 = new Book("Book One", "Author A", 2000, 20.0);
        Book book2 = new Book("Book Two", "Author B", 2010, 30.0);
        Book result = book1.plusRecent(book1, book2);
        Assertions.assertEquals(book2, result);
    }
}