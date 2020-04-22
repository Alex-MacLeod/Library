package library.commands;

import java.util.List;

public class UpdateCommandRunner implements LibraryCommandRunner {

    private final List<String> commandStrings;

    public UpdateCommandRunner(List<String> commandStrings) {
        this.commandStrings = commandStrings;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
