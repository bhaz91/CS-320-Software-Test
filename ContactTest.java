import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");

        assertEquals("C123", contact.getContactId());
        assertEquals("Brandon", contact.getFirstName());
        assertEquals("Hazelton", contact.getLastName());
        assertEquals("2565162825", contact.getPhone());
        assertEquals("601 Mastin Lake Rd NW", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testContactIdCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", null, "Hazelton", "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testFirstNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Christopher", "Hazelton", "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", null, "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testLastNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", "Montgomerys", "2565162825", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", "Hazelton", null, "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", "Hazelton", "256516282", "601 Mastin Lake Rd NW"));
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", "Hazelton", "2565162825", null));
    }

    @Test
    public void testAddressCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C123", "Brandon", "Hazelton", "2565162825", "1234567890123456789012345678901"));
    }

    @Test
    public void testSettersUpdateValidFields() {
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");

        contact.setFirstName("Dana");
        contact.setLastName("Poot");
        contact.setPhone("2569890277");
        contact.setAddress("New Address Lane");

        assertEquals("Dana", contact.getFirstName());
        assertEquals("Poot", contact.getLastName());
        assertEquals("2569890277", contact.getPhone());
        assertEquals("New Address Lane", contact.getAddress());
    }
}
