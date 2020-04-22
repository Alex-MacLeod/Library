package library.commands;

import java.util.List;

public class ReturnCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public ReturnCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
