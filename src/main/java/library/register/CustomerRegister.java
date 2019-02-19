package library.register;

import library.customer.Customer;
import library.util.JSONConverter;

import java.util.ArrayList;
import java.util.List;
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

    public static Customer find(UUID customerID) {
        for (Customer customer : customerList) {
            if (customerID.equals(customer.getId())){
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

    private CustomerRegister() {
    }
}
