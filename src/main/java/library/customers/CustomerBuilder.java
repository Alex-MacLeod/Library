package library.customers;

import java.time.LocalDate;

public class CustomerBuilder {

    private String name;
    private String email;
    private LocalDate dateOfBirth = LocalDate.now();
    private String[] address = new String[4];

    public CustomerBuilder() {
        //Builder class, empty constructor is required
    }

    public Customer buildCustomer() {
        return new Customer(name, email, dateOfBirth, address[0], address[1], address[2], address[3]);
    }

    public CustomerBuilder name(String name) {
        this.name = name;
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

    public CustomerBuilder address1(String address1) {
        this.address[0] = address1;
        return this;
    }

    public CustomerBuilder address2(String address2) {
        this.address[1] = address2;
        return this;
    }

    public CustomerBuilder address3(String address3) {
        this.address[2] = address3;
        return this;
    }

    public CustomerBuilder postCode(String postCode) {
        this.address[3] = postCode;
        return this;
    }
}
