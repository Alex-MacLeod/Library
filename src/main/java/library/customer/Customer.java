package library.customer;

import library.constant.Constant;
import library.item.Borrowable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface Customer {

    String[] getName();

    String getEmail();

    LocalDate getDateOfBirth();

    UUID getCustomerID();

    Address getAddress();

    List<Borrowable> getItemsBorrowed();

    void borrow(Borrowable item, long loanWeeks);

    default void borrow(Borrowable item) {
        borrow(item, Constant.STANDARD_LOAN_PERIOD_WEEKS);
    }

    void returnToLibrary(UUID itemID);
}
