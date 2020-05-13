package library.customer;

import library.item.Book;
import library.item.Borrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void newCustomerAutomaticallyGeneratesAnId() {
        // Given
        testCustomer = new CustomerBuilder().buildCustomer();

        // When
        UUID customerId = testCustomer.getId();

        // Then
        assertNotNull(customerId);
        assertEquals(2, customerId.variant()); // i.e. was generated using UUID class
        assertEquals(4, customerId.version()); // i.e. randomly generated UUID, UUID v4

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
    public void returnItemShouldNotRemoveItemFromItemsBorrowedIfCustomerHasNotBorrowedAnything() {
        // Given
        testCustomer = new CustomerBuilder().dob(LocalDate.now()).buildCustomer();

        assertEquals(0, testCustomer.getItemsBorrowed().size());

        // When
        testCustomer.returnToLibrary(testItem1.getID());

        // Then
        assertEquals(0, testCustomer.getItemsBorrowed().size());
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

    @Test
    public void updateCustomerShouldReturnCustomerWithNewDetails() {
        // Given
        testCustomer = new CustomerBuilder()
                .name("Peter Pevensie")
                .email("peterpevensie@anachronism.net")
                .dob(LocalDate.of(1927, 4, 4))
                .address(new Address("Kirke Mansion","Somewhereford",
                        "Countryside","W4R 0RB"))
                .buildCustomer();

        // When
        testCustomer = testCustomer.update("High King Peter the Magnificent",
                "kingpete@royal.co.nr",
                null,
                new Address("Royal Castle", "Cair Paravel", "Narnia", "AS1 4NN"));

        // Then
        assertEquals("High King Peter the Magnificent", testCustomer.getName());
        assertEquals("kingpete@royal.co.nr", testCustomer.getEmail());
        assertAll("Date of birth",
                () -> assertEquals(1927, testCustomer.getDateOfBirth().getYear()),
                () -> assertEquals(Month.APRIL, testCustomer.getDateOfBirth().getMonth()),
                () -> assertEquals(4, testCustomer.getDateOfBirth().getDayOfMonth())
        );
        assertAll("Address",
                () -> assertEquals("Royal Castle", testCustomer.getAddress().getStreetAddress()),
                () -> assertEquals("Cair Paravel", testCustomer.getAddress().getPlace()),
                () -> assertEquals("Narnia", testCustomer.getAddress().getCounty()),
                () -> assertEquals("AS1 4NN", testCustomer.getAddress().getPostCode())
        );
    }
}