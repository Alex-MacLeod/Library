package library.items;

import library.constants.Constants;

import java.time.LocalDate;
import java.util.UUID;

public interface Borrowable {

    UUID getID();

    boolean isOnLoan();

    void loan(long loanWeeks);

    default void loan() {
        loan(Constants.STANDARD_LOAN_PERIOD_WEEKS);
    }

    void returnFromLoan();

    LocalDate getLoanExpiryDate();

    void extendLoan(long weeksExtended);
}
