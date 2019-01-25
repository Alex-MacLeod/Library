package library.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import library.customer.Customer;
import library.item.Item;
import library.register.CustomerRegister;
import library.register.Library;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Command {

    private static List<Item> library;
    private static List<Customer> register;

    public enum Commands {
        ADD, EXIT, EXTEND, HELP, LOAN, OUTPUT, REMOVE, RETURN, UNKNOWN, UPDATE
    }

    public static final Map<Commands, Consumer<List<String>>> commandMap;

    static {
        final Map<Commands, Consumer<List<String>>> dummy = new EnumMap<>(Commands.class);
        dummy.put(Commands.ADD, Command::executeAdd);
        dummy.put(Commands.EXIT, Command::executeExit);
        dummy.put(Commands.EXTEND, Command::executeExtend);
        dummy.put(Commands.HELP, Command::executeHelp);
        dummy.put(Commands.LOAN, Command::executeLoan);
        dummy.put(Commands.OUTPUT, Command::executeOutput);
        dummy.put(Commands.REMOVE, Command::executeRemove);
        dummy.put(Commands.RETURN, Command::executeReturn);
        dummy.put(Commands.UNKNOWN, Command::executeUnknown);
        dummy.put(Commands.UPDATE, Command::executeUpdate);

        commandMap = Collections.unmodifiableMap(dummy);
    }

    private static void executeAdd(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private static void executeExit(List<String> commands) {
        System.out.println("Quitting library system");
    }

    private static void executeExtend(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private static void executeHelp(List<String> commands) {
        StringBuilder sb = new StringBuilder();
        for ( Commands val : Commands.values()) {
            sb.append(val.toString().toLowerCase());
            sb.append("', '");
        }
        String output = "Valid commands: '" + sb.toString();
        System.out.println(output.substring(0,output.length()-3));
    }

    private static void executeLoan(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private static void executeOutput(List<String> commands) {
        if ("library".equals(commands.get(1))) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            library = Library.getLibrary();

            library.parallelStream().forEach(item -> {
                try {
                    System.out.println(mapper.writeValueAsString(item));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        if ("customers".equals(commands.get(1))) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            register = CustomerRegister.getRegister();

            register.parallelStream().forEach(customer -> {
                try {
                    System.out.println(mapper.writeValueAsString(customer));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void executeRemove(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private static void executeReturn(List<String> commands) {
        throw new UnsupportedOperationException();
    }

    private static void executeUnknown(List<String> commands) {
        System.out.println("Did not recognise command \"" + commands.get(0) + "\". Use the \"help\" " +
                "command to see list of valid commands");
    }

    private static void executeUpdate(List<String> commands) {
        throw new UnsupportedOperationException();
    }

}
