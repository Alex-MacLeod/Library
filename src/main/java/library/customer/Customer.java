package library.customer;

import library.constant.Constant;
import library.item.Borrowable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface Customer {

    static Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String postCode){
        return new LibraryCustomerBuilder()
                .name(name).email(email).dob(dateOfBirth).address1(address1).postCode(postCode).buildCustomer();
    }

    static Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                       String postCode){
        return new LibraryCustomerBuilder()
                .name(name).email(email).dob(dateOfBirth).address1(address1).address2(address2).postCode(postCode)
                .buildCustomer();
    }

    static Customer createNew(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                       String address3, String postCode){
        return new LibraryCustomerBuilder()
                .name(name).email(email).dob(dateOfBirth)
                .address1(address1).address2(address2).address3(address3).postCode(postCode)
                .buildCustomer();
    }

    String getName();

    String getEmail();

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    UUID getCustomerID();

    Address getAddress();

    List<Borrowable> getItemsBorrowed();

    void borrow(Borrowable item, long loanWeeks);

    default void borrow(Borrowable item) {
        borrow(item, Constant.STANDARD_LOAN_PERIOD_WEEKS);
    }

    void returnToLibrary(UUID itemID);
}
