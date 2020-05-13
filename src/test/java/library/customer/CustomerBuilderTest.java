package library.customer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerBuilderTest {

    private Customer testCustomer;

    @Test
    public void libraryCustomerBuilderShouldCreateANewCustomer() {
        // Given
        Address newCustomerAddress = new Address("4 Privet Drive","Little Whinging",
                "Surrey","W1Z 4RD");

        // When
        testCustomer = new CustomerBuilder()
                .name("Harry Potter")
                .email("hpotter@hogwarts.ac.uk")
                .dob(LocalDate.of(1980, 7, 31))
                .address(newCustomerAddress)
                .buildCustomer();

        // Then
        assertEquals("Harry Potter", testCustomer.getName());
        assertEquals("hpotter@hogwarts.ac.uk", testCustomer.getEmail());
        assertAll("Date of birth",
                () -> assertEquals(1980, testCustomer.getDateOfBirth().getYear()),
                () -> assertEquals(Month.JULY, testCustomer.getDateOfBirth().getMonth()),
                () -> assertEquals(31, testCustomer.getDateOfBirth().getDayOfMonth())
        );
        assertAll("Address",
                () -> assertEquals("4 Privet Drive", testCustomer.getAddress().getStreetAddress()),
                () -> assertEquals("Little Whinging", testCustomer.getAddress().getPlace()),
                () -> assertEquals("Surrey", testCustomer.getAddress().getCounty()),
                () -> assertEquals("W1Z 4RD", testCustomer.getAddress().getPostCode())
        );
    }

    @Test
    public void emptyBuilderShouldCreateEmptyCustomer() {
        // When
        testCustomer = new CustomerBuilder().buildCustomer();

        // Then
        assertNull(testCustomer.getName());
        assertNull(testCustomer.getEmail());
        assertNull(testCustomer.getDateOfBirth());
        assertNull(testCustomer.getAddress());
        assertEquals(List.of(), testCustomer.getItemsBorrowed());
        assertNotNull(testCustomer.getId());
    }
}