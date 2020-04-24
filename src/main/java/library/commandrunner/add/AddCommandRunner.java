package library.commandrunner.add;

import library.commandrunner.LibraryCommandRunner;

import java.util.List;

public abstract class AddCommandRunner implements LibraryCommandRunner {

    // TODO: Write tests
    // TODO: Construct data object from: cmd, read file
    // TODO: Add object to correct register

    private final List<String> commandStrings;

    public AddCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Add' command not yet implemented");
    }
}
