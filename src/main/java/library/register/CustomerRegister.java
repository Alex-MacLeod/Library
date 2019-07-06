package library.register;

import library.customer.Customer;
import library.util.JSONConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerRegister {

    private static final Object mutex = new Object();
    private static volatile List<Customer> customerList;

    public static List<Customer> getRegister() {
        List<Customer> result = customerList;
        if (result == null) {
            synchronized (mutex) {
                result = customerList;
                if(result == null){
                    customerList = result = JSONConverter.readJsonList("/customers.json", Customer.class);
                }
            }
        }
        return result;
    }

    public static Optional<Customer> find(UUID customerID) {
        for (Customer customer : getRegister()) {
            if (customerID.equals(customer.getId())){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public static List<Customer> find(String name) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : getRegister()) {
            if (name.equals(customer.getName()[1])) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    private CustomerRegister() {
    }
}
