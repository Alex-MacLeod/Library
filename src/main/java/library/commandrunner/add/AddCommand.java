package library.commandrunner.add;

import library.commandrunner.LibraryCommand;

import java.util.List;

abstract class AddCommand<T> implements LibraryCommand {

    // TODO: Write tests
    // TODO: Construct data object from: cmd, read file
    // TODO: Add object to correct register

    protected final List<String> commandStrings;

    public AddCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    List<String> getCommandStrings() {
        return this.commandStrings;
    }

    abstract T createObjectToBeAdded();

    abstract void addToRegister(T object);

    @Override
    public void run() {
        addToRegister(createObjectToBeAdded());
    }
}
