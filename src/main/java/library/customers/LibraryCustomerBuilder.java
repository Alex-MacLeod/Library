package library.customers;

import java.time.LocalDate;

public class LibraryCustomerBuilder {

    private String name;
    private String email;
    private LocalDate dateOfBirth = LocalDate.now();
    private String[] address = new String[4];

    public LibraryCustomerBuilder() {
        //Builder class, empty constructor is required
    }

    public LibraryCustomer buildCustomer() {
        return new LibraryCustomer(name, email, dateOfBirth, address[0], address[1], address[2], address[3]);
    }

    public LibraryCustomerBuilder name(String name) {
        this.name = name;
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

    public LibraryCustomerBuilder address1(String address1) {
        this.address[0] = address1;
        return this;
    }

    public LibraryCustomerBuilder address2(String address2) {
        this.address[1] = address2;
        return this;
    }

    public LibraryCustomerBuilder address3(String address3) {
        this.address[2] = address3;
        return this;
    }

    public LibraryCustomerBuilder postCode(String postCode) {
        this.address[3] = postCode;
        return this;
    }
}
