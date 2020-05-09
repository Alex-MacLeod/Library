package library.commandrunner.extend;

import library.commandrunner.LibraryCommand;

import java.util.List;

public class ExtendCommand implements LibraryCommand {

    private final List<String> commandStrings;

    public ExtendCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Extend' command not yet implemented");
    }
}
