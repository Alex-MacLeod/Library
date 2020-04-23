package library.commandrunner.output;

import library.customer.Customer;
import library.register.CustomerRegister;
import library.writer.OutputWriter;

import java.util.List;

class OutputCustomersCommandRunner implements OutputCommandRunner {

    private final OutputWriter writer;

    public OutputCustomersCommandRunner(OutputWriter outputWriter) {
        this.writer = outputWriter;
    }

    @Override
    public void run() {
        List<Customer> list = CustomerRegister.getRegister();
        writer.output(list);
    }
}
