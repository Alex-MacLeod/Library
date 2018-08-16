package library.item;

import library.constant.Constant;
import library.customer.Customer;

import java.time.LocalDate;
import java.util.UUID;

public interface Borrowable {

    UUID getID();

    boolean isOnLoan();

    void loan(Customer customer, long loanWeeks);

    default void loan(Customer customer) {
        loan(customer, Constant.STANDARD_LOAN_PERIOD_WEEKS);
    }

    void returnFromLoan();

    LocalDate getLoanExpiryDate();

    void extendLoan(long weeksExtended);
}
