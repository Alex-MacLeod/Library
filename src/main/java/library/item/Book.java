package library.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import library.util.Constant;
import library.customer.Customer;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Item implements Borrowable {

    private final boolean isFiction;
    private final boolean isForKids;

    @JsonCreator
    public Book(@JsonProperty("name")String name,
                @JsonProperty("author")String author,
                @JsonProperty("yearPublished")int yearPublished,
                @JsonProperty("isFiction")boolean isFiction,
                @JsonProperty("isForKids")boolean isForKids) {
        super(name, author, yearPublished);
        this.isFiction = isFiction;
        this.isForKids = isForKids;
    }

    public boolean isFiction() {
        return isFiction;
    }

    public boolean isForKids() {
        return isForKids;
    }

    @Override
    public void loan(Customer customer, long loanWeeks) {
        if (!this.isForKids ||
                LocalDate.now().minusYears(Constant.AGE_OF_MINORITY).isAfter(customer.getDateOfBirth())) {
            this.onLoan = true;
            this.loanExpiryDate = LocalDate.now().plusWeeks(loanWeeks);
        } else {
            System.out.println("Customer is too young to borrow this book");
        }
    }

    @Override
    public void returnFromLoan() {
        this.onLoan = false;
        this.loanExpiryDate = null;
    }

    @Override
    public LocalDate getLoanExpiryDate() {
        return loanExpiryDate;
    }

    @Override
    public void extendLoan(long weeksExtended) {
        this.loanExpiryDate = this.loanExpiryDate.plusWeeks(weeksExtended);
    }
}
