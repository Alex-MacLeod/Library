package library.customer;

import library.item.Borrowable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class LibraryCustomer implements Customer {

    private String[] name;
    private String email;
    private LocalDate dateOfBirth;
    private final UUID customerID;
    private Address address;
    private List<Borrowable> itemsBorrowed;

    LibraryCustomer(String[] name, String email, LocalDate dateOfBirth, Address address) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.customerID = UUID.randomUUID();
        this.address = address;
        this.itemsBorrowed = new ArrayList<>();
    }

    @Override
    public String[] getName() {
        return this.name.clone();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public UUID getCustomerID() {
        return this.customerID;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public List<Borrowable> getItemsBorrowed() {
        return this.itemsBorrowed;
    }

    @Override
    public Customer update(String[] name, String email, LocalDate dateOfBirth, Address address) {
        this.name = name.clone();
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        return this;
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
        if (this.itemsBorrowed.isEmpty()) {
            System.out.println("Customer has not borrowed any books");
        } else {
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
}
