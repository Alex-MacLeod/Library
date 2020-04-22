package library.commands;

import java.util.List;

public class AddCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public AddCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
