package tp2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("123 Main St", customer.getDeliveryAddress());
        assertEquals("555-1234", customer.getPhoneNumber());
    }

    @Test
    public void testSetFirstName() {
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        customer.setFirstName("Jane");
        assertEquals("Jane", customer.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        customer.setLastName("Smith");
        assertEquals("Smith", customer.getLastName());
    }

    @Test
    public void testSetDeliveryAddress() {
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        customer.setDeliveryAddress("456 Elm St");
        assertEquals("456 Elm St", customer.getDeliveryAddress());
    }

    @Test
    public void testSetPhoneNumber() {
        Customer customer = new Customer("John", "Doe", "123 Main St", "555-1234");
        customer.setPhoneNumber("555-5678");
        assertEquals("555-5678", customer.getPhoneNumber());
    }
}
