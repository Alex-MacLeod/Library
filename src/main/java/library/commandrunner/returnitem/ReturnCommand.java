package library.commandrunner.returnitem;

import library.commandrunner.LibraryCommand;

import java.util.List;

public class ReturnCommand implements LibraryCommand {

    private final List<String> commandStrings;

    public ReturnCommand(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("'Return' command not yet implemented");
    }
}
