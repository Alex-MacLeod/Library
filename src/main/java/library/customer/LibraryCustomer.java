package library.customers;

import library.items.Borrowable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LibraryCustomer implements Customer{

    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private final UUID customerID;
    private String[] address;
    private List<Borrowable> itemsBorrowed;

    public LibraryCustomer(String name, String email, LocalDate dateOfBirth, String address1, String address2,
                    String address3, String postCode) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.customerID = UUID.randomUUID();
        this.address = new String[]{address1, address2, address3, postCode};
        this.itemsBorrowed = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public UUID getCustomerID() {
        return this.customerID;
    }

    @Override
    public String[] getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address1, String address2, String address3, String postCode) {
        this.address = new String[]{address1, address2, address3, postCode};
    }

    @Override
    public List<Borrowable> getItemsBorrowed() {
        return this.itemsBorrowed;
    }

    @Override
    public void borrow(Borrowable item, long loanWeeks) {
        if (!item.isOnLoan()) {
            item.loan(this, loanWeeks);
            if (item.isOnLoan()) {
                this.itemsBorrowed.add(item);
            }
        } else {
            System.out.println("You cannot borrow this item, it is already on loan!");
        }
    }

    @Override
    public void returnToLibrary(UUID itemID) {
        for (Borrowable item : this.itemsBorrowed) {
            if (itemID.equals(item.getID())) {
                itemsBorrowed.remove(item);
                item.returnFromLoan();
                break;
            } else {
                System.out.println("Customer has not borrowed this item, so cannot return it");
            }
        }
    }
}
