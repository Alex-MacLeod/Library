package library.customer;

import java.time.LocalDate;

public class LibraryCustomerBuilder {

    private String[] name;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;

    public LibraryCustomer buildCustomer() {
        return new LibraryCustomer(name, email, dateOfBirth, address);
    }

    public LibraryCustomerBuilder name(String forename, String surname) {
        this.name = new String[]{forename, surname};
        return this;
    }

    public LibraryCustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public LibraryCustomerBuilder dob(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public LibraryCustomerBuilder address(Address address) {
        this.address = new Address(address.getStreetAddress(), address.getPostCode());
        if (address.getTown() != null) {
            this.address.setTown(address.getTown());
        }
        if (address.getCounty() != null) {
            this.address.setCounty(address.getCounty());
        }
        return this;
    }
}
