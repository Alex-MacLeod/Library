package library.register;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.customer.Customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class CustomerRegister {

    private static volatile List<Customer> customerList;

    public static List<Customer> getRegister() {
        if (customerList == null) {
            synchronized (CustomerRegister.class) {
                if(customerList == null){
                    ObjectMapper mapper = new ObjectMapper();
                    try (InputStream is = CustomerRegister.class.getResourceAsStream("/customers.json")) {
                        customerList = mapper.readValue(is, new TypeReference<List<Customer>>() {});
                        System.out.println("Customer register initialised"); // debug
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return customerList;
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
