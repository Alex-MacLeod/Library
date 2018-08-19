package library.customer;

import library.item.Book;
import library.item.Borrowable;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer testCustomer;

    private Borrowable testItem1;
    private Borrowable testItem2;

    @Before
    public void setUp() {
        testCustomer = new LibraryCustomerBuilder().name("Joe Bloggs").email("joebloggs@email.com").buildCustomer();

        testItem1 = new Book("Java 4 Dum-Dums", "Elliot Womack",2017,
                false, false);
        testItem2 = new Book("Cognitive Psience", "Wakaba Isshiki",2016,
                false, true);
    }

    @Test
    public void createNewShouldCreateANewCustomer() {
        Customer newCustomer1 = Customer.createNew("John Doe", "johndoe@email.com",
                LocalDate.of(1965, 8, 19), "141 5th Street", "Z1PC0DE");

        assertEquals("John Doe", newCustomer1.getName());
        assertEquals("johndoe@email.com", newCustomer1.getEmail());
        assertEquals(1965, newCustomer1.getDateOfBirth().getYear());
        assertEquals(Month.AUGUST, newCustomer1.getDateOfBirth().getMonth());
        assertEquals(19, newCustomer1.getDateOfBirth().getDayOfMonth());
        assertEquals("141 5th Street", newCustomer1.getAddress()[0]);
        assertNull(newCustomer1.getAddress()[1]);
        assertNull(newCustomer1.getAddress()[2]);
        assertEquals("Z1PC0DE", newCustomer1.getAddress()[3]);

        Customer newCustomer2 = Customer.createNew("Samwise Gamgee", "gardeninglyfe@palantir.net",
                LocalDate.of(2980, 4, 6), "Bag End",
                "Hobbiton","HO8 81T");

        assertEquals("Samwise Gamgee", newCustomer2.getName());
        assertEquals("gardeninglyfe@palantir.net", newCustomer2.getEmail());
        assertEquals(2980, newCustomer2.getDateOfBirth().getYear());
        assertEquals(Month.APRIL, newCustomer2.getDateOfBirth().getMonth());
        assertEquals(6, newCustomer2.getDateOfBirth().getDayOfMonth());
        assertEquals("Bag End", newCustomer2.getAddress()[0]);
        assertEquals("Hobbiton", newCustomer2.getAddress()[1]);
        assertNull(newCustomer2.getAddress()[2]);
        assertEquals("HO8 81T", newCustomer2.getAddress()[3]);

        Customer newCustomer3 = Customer.createNew("Harry Potter", "hpotter@hogwarts.ac.uk",
                LocalDate.of(1980, 7, 31), "4 Privet Drive",
                "Little Whinging","Surrey","W1Z 4RD");

        assertEquals("Harry Potter", newCustomer3.getName());
        assertEquals("hpotter@hogwarts.ac.uk", newCustomer3.getEmail());
        assertEquals(1980, newCustomer3.getDateOfBirth().getYear());
        assertEquals(Month.JULY, newCustomer3.getDateOfBirth().getMonth());
        assertEquals(31, newCustomer3.getDateOfBirth().getDayOfMonth());
        assertEquals("4 Privet Drive", newCustomer3.getAddress()[0]);
        assertEquals("Little Whinging", newCustomer3.getAddress()[1]);
        assertEquals("Surrey", newCustomer3.getAddress()[2]);
        assertEquals("W1Z 4RD", newCustomer3.getAddress()[3]);
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
    public void borrowShouldAddItemToItemsBorrowedOnlyIfNotOnLoan() {
        testCustomer.borrow(testItem1);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.borrow(testItem1, 6);

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void borrowShouldNotAddItemToItemsBorrowedIfItemRejectsLoan() {
        testCustomer.borrow(testItem2);

        assertEquals(0, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldRemoveItemFromItemsBorrowedIfCustomerHasBorrowedIt() {
        testCustomer.setDateOfBirth(LocalDate.of(1990,1,1));

        testCustomer.borrow(testItem1);
        testCustomer.borrow(testItem2);

        assertEquals(2, testCustomer.getItemsBorrowed().size());

        testCustomer.returnToLibrary(testItem1.getID());

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldNotRemoveItemFromItemsBorrowedIfCustomerHasNotBorrowedIt() {
        testCustomer.borrow(testItem1);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.returnToLibrary(testItem2.getID());

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }
}