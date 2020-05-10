package library.commandrunner.update;

import library.commandrunner.LibraryCommand;

import java.util.List;

public class UpdateCommand implements LibraryCommand {

    private final List<String> commandStrings;

    public UpdateCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Update' command not yet implemented");
    }
}
