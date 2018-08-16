package library.customer;

import library.constant.Constant;
import library.item.Borrowable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface Customer {

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

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
