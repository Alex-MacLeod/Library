package library.commandrunner.output;

import library.customer.Customer;
import library.register.CustomerRegister;
import library.util.JSONConverter;

import java.util.List;

class OutputCustomersCommandRunner implements OutputCommandRunner {

    @Override
    public void run() {
        List<Customer> list = CustomerRegister.getRegister();
        JSONConverter.outputJson(list);
    }
}
