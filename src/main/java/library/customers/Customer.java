package library.customers;

import library.items.Item;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {

    private String forename;
    private String surname;
    private final LocalDate dateOfBirth;
    private final UUID customerID;
    private String[] address;
    private Item[] itemsBorrowed;

    public Customer(String forename, String surname, String dateOfBirth, String address1, String address2, String address3, String postCode) {
        this.forename = forename;
        this.surname = surname;

        String[] dob = dateOfBirth.split("/");
        this.dateOfBirth = LocalDate.of(Integer.parseInt(dob[0]), Integer.parseInt(dob[1]),  Integer.parseInt(dob[2]));

        this.customerID = UUID.fromString(forename + surname);
        this.address = new String[]{address1, address2, address3, postCode};

        this.itemsBorrowed = null;
    }

    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
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

    public Item[] getItemsBorrowed() {
        return this.itemsBorrowed;
    }

    public void checkOutItem (String itemName) {
        //add item to itemsBorrowed
    }

    public void checkOutItem (UUID itemID) {
        //add item to itemsBorrowed
    }

    public void checkInItem (UUID itemID) {
        //remove item from itemsBorrowed
    }
}
