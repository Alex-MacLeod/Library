package library.commandrunner.add;

import java.util.List;

public class AddCommandRunnerFactory {

    private AddCommandRunnerFactory() {}

    public static AddCommandRunner getAddCommandRunner(List<String> commandStrings) {
        String dataTypeToBeAdded = commandStrings.get(1);
        if ("item".equals(dataTypeToBeAdded)) {
            return new AddLibraryItemCommandRunner(commandStrings);
        } else if ("customer".equals(dataTypeToBeAdded)) {
            return new AddCustomerCommandRunner(commandStrings);
        } else {
            throw new IllegalArgumentException("Did not recognise '" + dataTypeToBeAdded + "' as a valid data type to be added");
        }
    }
}
