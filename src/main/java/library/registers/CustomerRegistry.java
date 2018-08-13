package library.registers;

import library.customers.Customer;

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

    public static List<Customer> find(String forename, String surname) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (forename.equals(customer.getForename()) && surname.equals(customer.getForename())) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    private CustomerRegistry() {
    }
}
