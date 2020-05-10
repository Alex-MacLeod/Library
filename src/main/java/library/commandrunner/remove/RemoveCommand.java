package library.commandrunner.remove;

import library.commandrunner.LibraryCommand;

import java.util.List;

public class RemoveCommand implements LibraryCommand {

    private final List<String> commandStrings;

    public RemoveCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Remove' command not yet implemented");
    }
}
