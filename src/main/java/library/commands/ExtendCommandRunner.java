package library.commands;

import java.util.List;

public class ExtendCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public ExtendCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
