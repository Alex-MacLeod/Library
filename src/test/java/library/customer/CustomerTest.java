package library.customer;

import library.item.Book;
import library.item.Borrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    private Customer testCustomer;

    private Borrowable testItem1;
    private Borrowable testItem2;

    @BeforeEach
    public void setUp() {
        testItem1 = new Book("Java 4 Dum-Dums", "Elliot Womack",2017,
                false, true);
        testItem2 = new Book("Cognitive Psience", "Wakaba Isshiki",2016,
                false, false);
    }

    @Test
    public void borrowShouldAddItemToItemsBorrowedOnlyIfNotOnLoan() {
        // Given
        testCustomer = new CustomerBuilder().dob(LocalDate.now()).buildCustomer();

        // When
        testCustomer.borrow(testItem2);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        testCustomer.borrow(testItem2, 6L);

        // Then
        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void borrowShouldNotAddItemToItemsBorrowedIfItemRejectsLoan() {
        // Given
        testCustomer = new CustomerBuilder().dob(LocalDate.now()).buildCustomer();

        // When
        testCustomer.borrow(testItem1);

        // Then
        assertEquals(0, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldRemoveItemFromItemsBorrowedIfCustomerHasBorrowedIt() {
        // Given
        testCustomer = new CustomerBuilder().dob(LocalDate.of(1990,1,1)).buildCustomer();

        testCustomer.borrow(testItem1);
        testCustomer.borrow(testItem2);

        assertEquals(2, testCustomer.getItemsBorrowed().size());

        // When
        testCustomer.returnToLibrary(testItem1.getID());

        // Then
        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }

    @Test
    public void returnItemShouldNotRemoveItemFromItemsBorrowedIfCustomerHasNotBorrowedIt() {
        // Given
        testCustomer = new CustomerBuilder().dob(LocalDate.now()).buildCustomer();
        testCustomer.borrow(testItem2);

        assertEquals(1, testCustomer.getItemsBorrowed().size());

        // When
        testCustomer.returnToLibrary(testItem1.getID());

        // Then
        assertEquals(1, testCustomer.getItemsBorrowed().size());
    }
}