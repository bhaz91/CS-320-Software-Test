import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");

        service.addContact(contact);

        assertEquals(contact, service.getContact("C123"));
    }

    @Test
    public void testAddNullContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");
        Contact contact2 = new Contact("C123", "Dana", "Poot", "2569890277", "Other Address");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");

        service.addContact(contact);
        service.deleteContact("C123");

        assertNull(service.getContact("C123"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("C123"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");
        service.addContact(contact);

        service.updateFirstName("C123", "Dana");

        assertEquals("Dana", service.getContact("C123").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");
        service.addContact(contact);

        service.updateLastName("C123", "Poot");

        assertEquals("Poot", service.getContact("C123").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");
        service.addContact(contact);

        service.updatePhone("C123", "2569890277");

        assertEquals("2569890277", service.getContact("C123").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "Brandon", "Hazelton", "2565162825", "601 Mastin Lake Rd NW");
        service.addContact(contact);

        service.updateAddress("C123", "New Address Lane");

        assertEquals("New Address Lane", service.getContact("C123").getAddress());
    }

    @Test
    public void testUpdateMissingContactThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("C999", "2569890277"));
    }
}
