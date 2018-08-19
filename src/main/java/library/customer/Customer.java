package library.customer;

import library.constant.Constant;
import library.item.Borrowable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface Customer {

    Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String postCode);

    Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                       String postCode);

    Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                       String address3, String postCode);

    String getName();

    String getEmail();

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    UUID getCustomerID();

    String[] getAddress();

    void setAddress(String address1, String address2, String address3, String postCode);

    List<Borrowable> getItemsBorrowed();

    void borrow(Borrowable item, long loanWeeks);

    default void borrow(Borrowable item) {
        borrow(item, Constant.STANDARD_LOAN_PERIOD_WEEKS);
    }

    void returnToLibrary(UUID itemID);
}
