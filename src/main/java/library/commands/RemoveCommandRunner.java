package library.commands;

import java.util.List;

public class RemoveCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public RemoveCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
