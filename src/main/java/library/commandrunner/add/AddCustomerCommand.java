package library.commandrunner.add;

import library.customer.Customer;
import library.customer.CustomerBuilder;

import java.util.List;

class AddCustomerCommand extends AddCommand<Customer> {

    public AddCustomerCommand(List<String> commandStrings) {
        super(commandStrings);
    }

    @Override
    Customer createObjectToBeAdded() {
        final String name = commandStrings.size() > 1 ? commandStrings.get(1) : null;
        final String email = commandStrings.size() > 2 ? commandStrings.get(2) : null;
        final String dob = commandStrings.size() > 3 ? commandStrings.get(3) : null;
        final String address = commandStrings.size() > 4 ? commandStrings.get(4) : null;

        return new CustomerBuilder()
                .name(name)
                .email(email)
                .dob(dob)
                .address(address)
                .buildCustomer();
    }

    @Override
    void addToRegister(Customer object) {

    }
}
