package library.customer;

import java.time.LocalDate;

public class CustomerBuilder {

    private String[] name;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;

    public Customer buildCustomer() {
        return new Customer(name, email, dateOfBirth, address);
    }

    public CustomerBuilder name(String forename, String surname) {
        this.name = new String[]{forename, surname};
        return this;
    }

    public CustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder dob(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CustomerBuilder address(Address address) {
        this.address = new Address(address.getStreetAddress(), address.getPostCode());
        if (address.getPlace() != null) {
            this.address.setPlace(address.getPlace());
        }
        if (address.getCounty() != null) {
            this.address.setCounty(address.getCounty());
        }
        return this;
    }
}
