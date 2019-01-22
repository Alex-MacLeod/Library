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
        testItem1 = new Book("Java 4 Dum-Dums", "Elliot Womack",2017,
                false, true);
        testItem2 = new Book("Cognitive Psience", "Wakaba Isshiki",2016,
                false, false);
    }

    @Test
    public void libraryCustomerBuilderShouldCreateANewCustomer() {
        Address newCustomerAddress = new Address("4 Privet Drive","Little Whinging",
                "Surrey","W1Z 4RD");

        testCustomer = new LibraryCustomerBuilder()
                .name("Harry", "Potter").email("hpotter@hogwarts.ac.uk")
                .dob(LocalDate.of(1980, 7, 31)).address(newCustomerAddress)
                .buildCustomer();

        String[] expectedName3 = new String[]{"Harry", "Potter"};

        assertArrayEquals(expectedName3, testCustomer.getName());
        assertEquals("hpotter@hogwarts.ac.uk", testCustomer.getEmail());
        assertEquals(1980, testCustomer.getDateOfBirth().getYear());
        assertEquals(Month.JULY, testCustomer.getDateOfBirth().getMonth());
        assertEquals(31, testCustomer.getDateOfBirth().getDayOfMonth());
        assertEquals("4 Privet Drive", testCustomer.getAddress().getStreetAddress());
        assertEquals("Little Whinging", testCustomer.getAddress().getTown());
        assertEquals("Surrey", testCustomer.getAddress().getCounty());
        assertEquals("W1Z 4RD", testCustomer.getAddress().getPostCode());
    }

    @Test
    public void borrowShouldAddItemToItemsBorrowedOnlyIfNotOnLoan() {
        testCustomer = new LibraryCustomerBuilder().dob(LocalDate.now()).buildCustomer();
        testCustomer.borrow(testItem2);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.borrow(testItem2, 6);

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void borrowShouldNotAddItemToItemsBorrowedIfItemRejectsLoan() {
        testCustomer = new LibraryCustomerBuilder().dob(LocalDate.now()).buildCustomer();
        testCustomer.borrow(testItem1);

        assertEquals(0, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldRemoveItemFromItemsBorrowedIfCustomerHasBorrowedIt() {
        testCustomer = new LibraryCustomerBuilder().dob(LocalDate.of(1990,1,1)).buildCustomer();

        testCustomer.borrow(testItem1);
        testCustomer.borrow(testItem2);

        assertEquals(2, testCustomer.getItemsBorrowed().size());

        testCustomer.returnToLibrary(testItem1.getID());

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldNotRemoveItemFromItemsBorrowedIfCustomerHasNotBorrowedIt() {
        testCustomer = new LibraryCustomerBuilder().dob(LocalDate.now()).buildCustomer();
        testCustomer.borrow(testItem2);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.returnToLibrary(testItem1.getID());

        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }
}