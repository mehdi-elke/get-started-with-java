package fr.baretto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    Book book1, book2,book3;
    @BeforeEach
    public void setUp() {
        book1 = new Book("Harry Potter", "J.K. Rowling", 1997, 10);
        book2 = new Book("Harry Potter", "J.K. Rowling", 2000, 200);
        book3 = new Book("Harry Potter 2", "J.K. Rowling", 2003, 10);

    }

    @Test
    public void shouldBeEqual() {
        Assertions.assertEquals(book1, book2);
        Assertions.assertEquals(book2, book1);
    }

    @Test
    public void shouldBeNotEqual() {
        Assertions.assertNotEquals(book1, book3);
        Assertions.assertNotEquals(book2, book3);
    }

    @Test
    public void shouldReturnBookToString() {
        Assertions.assertEquals("Book{title='Harry Potter', author='J.K. Rowling', yearPublished=1997, price=10}", book1.toString());
        Assertions.assertEquals("Book{title='Harry Potter', author='J.K. Rowling', yearPublished=2000, price=200}", book2.toString());
        Assertions.assertEquals("Book{title='Harry Potter 2', author='J.K. Rowling', yearPublished=2003, price=10}", book3.toString());
    }

    @Test
    public void shouldApplyDiscount() {
        Assertions.assertEquals(5, book1.applyDiscount(0.5));
    }

    @Test
    public void shouldComparePublishedYear() {
        Assertions.assertEquals(book2, book1.compareYearPublished(book2));
        Assertions.assertEquals(book3, book3.compareYearPublished(book1));
        Assertions.assertEquals(book3, book1.compareYearPublished(book3));
    }


}
