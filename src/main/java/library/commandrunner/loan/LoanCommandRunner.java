package library.commandrunner.loan;

import library.commandrunner.LibraryCommandRunner;
import library.customer.Customer;
import library.item.Borrowable;
import library.item.Item;
import library.register.CustomerRegister;
import library.register.Library;
import library.util.Constant;
import library.util.JSONConverter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class LoanCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public LoanCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        //command: loan customer item
        UUID customerId = UUID.fromString(commandStrings.get(1));
        UUID itemId = UUID.fromString(commandStrings.get(2));

        Customer customer = CustomerRegister.find(customerId).orElseThrow(IllegalArgumentException::new);
        Item item = Library.find(itemId).orElseThrow(IllegalArgumentException::new);

        if (item instanceof Borrowable) {
            customer.borrow((Borrowable) item);
            try {
                JSONConverter.writeJson(CustomerRegister.getRegister(), Constant.CUSTOMER_FILE);
                JSONConverter.writeJson(Library.getLibrary(), Constant.LIBRARY_FILE);
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot borrow this item");
        }
    }
}
