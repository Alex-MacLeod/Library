package library.commandrunner.add;

import library.commandrunner.add.annotation.AddDataType;

import java.util.List;

public class AddCommandFactory {

    private AddCommandFactory() {}

    public static AddCommand<?> getAddCommand(List<String> commandStrings) {
        @SuppressWarnings("deprecation")
        @AddDataType(message = "Not a valid thing to be added") String dataTypeToBeAdded = commandStrings.get(1);
        if ("item".equals(dataTypeToBeAdded)) {
            return new AddLibraryItemCommand(commandStrings);
        } else if ("customer".equals(dataTypeToBeAdded)) {
            return new AddCustomerCommand(commandStrings);
        } else {
            throw new IllegalArgumentException("Did not recognise '" + dataTypeToBeAdded + "' as a valid data type to be added");
        }
    }
}
