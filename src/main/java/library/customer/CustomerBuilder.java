package library.customer;

import java.time.LocalDate;

public class CustomerBuilder {

    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;

    public Customer buildCustomer() {
        return new Customer(name, email, dateOfBirth, address);
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

    public CustomerBuilder dob(String dateOfBirth) {
        if (dateOfBirth == null) {
            return this;
        }
        return dob(LocalDate.parse(dateOfBirth));
    }

    public CustomerBuilder address(Address address) {
        if (address == null) {
            return this;
        }
        this.address = new Address(address.getStreetAddress(), address.getPostCode());
        if (address.getPlace() != null) {
            this.address.setPlace(address.getPlace());
        }
        if (address.getCounty() != null) {
            this.address.setCounty(address.getCounty());
        }
        return this;
    }

    public CustomerBuilder address(String addressInput) {
        if (addressInput == null) {
            return this;
        }
        Address inputtedAddress;
        String[] addressStrings = addressInput.split("\n");
        if (addressStrings.length < 2 || addressStrings.length > 4) throw new IllegalArgumentException("Incorrect number of arguments for address");
        else if (addressStrings.length == 2) inputtedAddress = new Address(addressStrings[0], addressStrings[1]);
        else if (addressStrings.length == 3) inputtedAddress = new Address(addressStrings[0], addressStrings[1], addressStrings[2]);
        else inputtedAddress = new Address(addressStrings[0], addressStrings[1], addressStrings[2], addressStrings[3]);
        return address(inputtedAddress);
    }

}
