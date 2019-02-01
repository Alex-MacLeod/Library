package library.service;

import library.util.Command;
import library.customer.Customer;
import library.item.Borrowable;
import library.item.Item;
import library.register.CustomerRegister;
import library.register.Library;
import library.util.JSONConverter;

import java.io.IOException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class LibraryService {

    public Map<Command, Consumer<List<String>>> commandMap() {
        final Map<Command, Consumer<List<String>>> dummy = new EnumMap<>(Command.class);
        dummy.put(Command.ADD, this::executeAdd);
        dummy.put(Command.EXIT, this::executeExit);
        dummy.put(Command.EXTEND, this::executeExtend);
        dummy.put(Command.HELP, this::executeHelp);
        dummy.put(Command.LOAN, this::executeLoan);
        dummy.put(Command.OUTPUT, this::executeOutput);
        dummy.put(Command.REMOVE, this::executeRemove);
        dummy.put(Command.RETURN, this::executeReturn);
        dummy.put(Command.UNKNOWN, this::executeUnknown);
        dummy.put(Command.UPDATE, this::executeUpdate);

        return Collections.unmodifiableMap(dummy);
    }

    private void executeAdd(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private void executeExit(List<String> commands) {
        System.out.println("Quitting library system");
    }

    private void executeExtend(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private void executeHelp(List<String> commands) {
        StringBuilder sb = new StringBuilder();
        for ( Command val : Command.values()) {
            sb.append(val.toString().toLowerCase());
            sb.append("', '");
        }
        String output = "Valid commands: '" + sb.toString();
        System.out.println(output.substring(0,output.length()-3));
    }

    private void executeLoan(List<String> commands) {
        //command: loan customer item
        UUID customerId = UUID.fromString(commands.get(1));
        UUID itemId = UUID.fromString(commands.get(2));

        Customer customer = CustomerRegister.find(customerId).orElseThrow(IllegalArgumentException::new);
        Item item = Library.find(itemId).orElseThrow(IllegalArgumentException::new);

        if (item instanceof Borrowable) {
            customer.borrow((Borrowable) item);
            try {
                JSONConverter.writeJson(CustomerRegister.getRegister(), "/customers1.json");
                JSONConverter.writeJson(Library.getLibrary(), "/library1.json");
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot borrow this item");
        }
    }

    private void executeOutput(List<String> commands) {
        List<?> list;
        if ("library".equals(commands.get(1))) {
            list = Library.getLibrary();
            JSONConverter.outputJson(list);
        } else if ("customers".equals(commands.get(1))) {
            list = CustomerRegister.getRegister();
            JSONConverter.outputJson(list);
        } else {
            System.out.println("Did not recognise '" + commands.get(1) + "' as a valid output");
        }
    }

    private void executeRemove(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private void executeReturn(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private void executeUnknown(List<String> commands) {
        System.out.println("Did not recognise command \"" + commands.get(0) + "\". Use the \"help\" " +
                "command to see list of valid commands");
    }

    private void executeUpdate(List<String> commands) {
        throw new UnsupportedOperationException();
    }
}
