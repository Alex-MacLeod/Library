package library.customers;

import library.items.Borrowable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private final UUID customerID;
    private String[] address;
    private List<Borrowable> itemsBorrowed;

    Customer(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                    String address3, String postCode) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.customerID = UUID.randomUUID();
        this.address = new String[]{address1, address2, address3, postCode};
        this.itemsBorrowed = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String surname) {
        this.name = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setName(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getCustomerID() {
        return this.customerID;
    }

    public String[] getAddress() {
        return this.address;
    }

    public void setAddress(String address1, String address2, String address3, String postCode) {
        this.address = new String[]{address1, address2, address3, postCode};
    }

    public List<Borrowable> getItemsBorrowed() {
        return this.itemsBorrowed;
    }

    public void borrow(Borrowable item) {
        this.itemsBorrowed.add(item);
        item.loan();
    }

    public void borrow(Borrowable item, Long loanWeeks) {
        this.itemsBorrowed.add(item);
        item.loan(loanWeeks);
    }

    public void returnToLibrary(UUID itemID) {
        for (Borrowable item : this.itemsBorrowed) {
            if (itemID.equals(item.getID())) {
                itemsBorrowed.remove(item);
                item.returnFromLoan();
                break;
            }
        }
    }
}
