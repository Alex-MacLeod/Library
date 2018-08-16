package library.customers;

import library.items.Book;
import library.items.Borrowable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer testCustomer;

    private Borrowable testItem1;
    private Borrowable testItem2;

    @Before
    public void setUp() {
        testCustomer = new LibraryCustomerBuilder().name("Joe Bloggs").email("joebloggs@email.com").buildCustomer();

        testItem1 = new Book("Java 4 Dum-Dums", "Elliot Womack",2017,
                false, true);
        testItem2 = new Book("Cognitive Psience", "Wakaba Isshiki",2016,
                false, false);
    }

    @Test
    public void setAddressShouldCombineValuesIntoArray() {
        String address1 = "20 Random Road";
        String address2 = "Normalford";
        String address3 = "Genericshire";
        String postCode = "NW4 T3S";
        String[] testAddress = {address1, address2, address3, postCode};
        testCustomer.setAddress(address1, address2, address3, postCode);

        assertArrayEquals(testAddress, testCustomer.getAddress());
    }

    @Test
    public void borrowShouldAddItemToItemsBorrowed() {
        testCustomer.borrow(testItem1);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.borrow(testItem2, 6L);

        assertEquals(2, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItem() {
        testCustomer.borrow(testItem1);
        testCustomer.borrow(testItem2);

        testCustomer.returnToLibrary(testItem1.getID());

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }
}