package library.commandrunner.add;

import library.commandrunner.LibraryCommand;

import java.util.List;

abstract class AddCommand implements LibraryCommand {

    // TODO: Write tests
    // TODO: Construct data object from: cmd, read file
    // TODO: Add object to correct register

    private final List<String> commandStrings;

    public AddCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Add' command not yet implemented");
    }
}
