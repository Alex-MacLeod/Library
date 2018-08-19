package library.customer;

import java.time.LocalDate;

class LibraryCustomerBuilder {

    private String name;
    private String email;
    private LocalDate dateOfBirth = LocalDate.now();
    private String[] address = new String[4];

    LibraryCustomerBuilder() {
        //Builder class, empty constructor is required
    }

    LibraryCustomer buildCustomer() {
        return new LibraryCustomer(name, email, dateOfBirth, address[0], address[1], address[2], address[3]);
    }

    LibraryCustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    LibraryCustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    LibraryCustomerBuilder dob(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    LibraryCustomerBuilder address1(String address1) {
        this.address[0] = address1;
        return this;
    }

    LibraryCustomerBuilder address2(String address2) {
        this.address[1] = address2;
        return this;
    }

    LibraryCustomerBuilder address3(String address3) {
        this.address[2] = address3;
        return this;
    }

    LibraryCustomerBuilder postCode(String postCode) {
        this.address[3] = postCode;
        return this;
    }
}
