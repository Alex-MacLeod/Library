package library.register;

import library.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRegistry {

    private static List<Customer> customerList =  new ArrayList<>();

    public static List<Customer> getRegister() {
        return customerList;
    }

    public static Customer find(UUID customerID) {
        for (Customer customer : customerList) {
            if (customerID.equals(customer.getCustomerID())){
                return customer;
            }
        }
        return null;
    }

    public static List<Customer> find(String name) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (name.equals(customer.getName())) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    private CustomerRegistry() {
    }
}
