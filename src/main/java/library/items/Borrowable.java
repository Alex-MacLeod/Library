package library.items;

import java.time.LocalDate;
import java.util.UUID;

public interface Borrowable {

    UUID getID();

    void loan(long loanWeeks);

    void loan();

    void returnFromLoan();

    LocalDate getLoanExpiryDate();

    void extendLoan(long weeksExtended);
}
