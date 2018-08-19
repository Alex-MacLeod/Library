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
        testCustomer = new LibraryCustomerBuilder().name("Joe", "Bloggs").buildCustomer();

        testItem1 = new Book("Java 4 Dum-Dums", "Elliot Womack",2017,
                false, false);
        testItem2 = new Book("Cognitive Psience", "Wakaba Isshiki",2016,
                false, true);
    }

    @Test
    public void createNewShouldCreateANewCustomer() {
        Customer newCustomer1 = LibraryCustomer.createNew("John", "Doe", "johndoe@email.com",
                LocalDate.of(1965, 8, 19), "141 5th Street", "Z1PC0DE");
        String[] expectedName1 = new String[]{"John", "Doe"};

        assertArrayEquals(expectedName1, newCustomer1.getName());
        assertEquals("johndoe@email.com", newCustomer1.getEmail());
        assertEquals(1965, newCustomer1.getDateOfBirth().getYear());
        assertEquals(Month.AUGUST, newCustomer1.getDateOfBirth().getMonth());
        assertEquals(19, newCustomer1.getDateOfBirth().getDayOfMonth());
        assertEquals("141 5th Street", newCustomer1.getAddress().getStreetAddress());
        assertNull(newCustomer1.getAddress().getTown());
        assertNull(newCustomer1.getAddress().getCounty());
        assertEquals("Z1PC0DE", newCustomer1.getAddress().getPostCode());

        Customer newCustomer2 = LibraryCustomer.createNew("Samwise", "Gamgee",
                "gardeninglyfe@palantir.net", LocalDate.of(2980, 4, 6),
                "Bag End","Hobbiton","HO8 81T");
        String[] expectedName2 = new String[]{"Samwise", "Gamgee"};

        assertArrayEquals(expectedName2, newCustomer2.getName());
        assertEquals("gardeninglyfe@palantir.net", newCustomer2.getEmail());
        assertEquals(2980, newCustomer2.getDateOfBirth().getYear());
        assertEquals(Month.APRIL, newCustomer2.getDateOfBirth().getMonth());
        assertEquals(6, newCustomer2.getDateOfBirth().getDayOfMonth());
        assertEquals("Bag End", newCustomer2.getAddress().getStreetAddress());
        assertEquals("Hobbiton", newCustomer2.getAddress().getTown());
        assertNull(newCustomer2.getAddress().getCounty());
        assertEquals("HO8 81T", newCustomer2.getAddress().getPostCode());

        Customer newCustomer3 = LibraryCustomer.createNew("Harry", "Potter",
                "hpotter@hogwarts.ac.uk", LocalDate.of(1980, 7, 31),
                "4 Privet Drive","Little Whinging","Surrey","W1Z 4RD");
        String[] expectedName3 = new String[]{"Harry", "Potter"};

        assertArrayEquals(expectedName3, newCustomer3.getName());
        assertEquals("hpotter@hogwarts.ac.uk", newCustomer3.getEmail());
        assertEquals(1980, newCustomer3.getDateOfBirth().getYear());
        assertEquals(Month.JULY, newCustomer3.getDateOfBirth().getMonth());
        assertEquals(31, newCustomer3.getDateOfBirth().getDayOfMonth());
        assertEquals("4 Privet Drive", newCustomer3.getAddress().getStreetAddress());
        assertEquals("Little Whinging", newCustomer3.getAddress().getTown());
        assertEquals("Surrey", newCustomer3.getAddress().getCounty());
        assertEquals("W1Z 4RD", newCustomer3.getAddress().getPostCode());
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