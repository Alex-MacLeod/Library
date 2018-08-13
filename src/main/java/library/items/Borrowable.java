package library.items;

import java.time.LocalDate;

public interface Borrowable {

    void loan(long loanWeeks);

    void returnFromLoan();

    LocalDate getLoanExpiryDate();

    void extendLoan(long weeksExtended);
}
