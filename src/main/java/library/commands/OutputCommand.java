package library.commands;

import library.register.CustomerRegister;
import library.register.Library;
import library.util.JSONConverter;

import java.util.List;

public class OutputCommand implements LibraryCommand {

    private final List<String> commandStrings;

    public OutputCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        List<?> list;
        if ("library".equals(commandStrings.get(1))) {
            list = Library.getLibrary();
            JSONConverter.outputJson(list);
        } else if ("customers".equals(commandStrings.get(1))) {
            list = CustomerRegister.getRegister();
            JSONConverter.outputJson(list);
        } else {
            System.out.println("Did not recognise '" + commandStrings.get(1) + "' as a valid output");
        }
    }
}
