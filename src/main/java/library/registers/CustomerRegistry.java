package library.registers;

import library.customers.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRegistry {

    private static List<Customer> libraryCustomerList =  new ArrayList<>();

    public static List<Customer> getRegister() {
        return libraryCustomerList;
    }

    public static Customer find(UUID customerID) {
        for (Customer customer : libraryCustomerList) {
            if (customerID.equals(customer.getCustomerID())){
                return customer;
            }
        }
        return null;
    }

    public static List<Customer> find(String name) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : libraryCustomerList) {
            if (name.equals(customer.getName())) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    private CustomerRegistry() {
    }
}
