package library.commandrunner.output;

import library.commandrunner.LibraryCommandRunner;
import library.io.writer.OutputWriter;

abstract class OutputCommandRunner implements LibraryCommandRunner {

    private final OutputWriter writer;

    public OutputCommandRunner(OutputWriter outputWriter) {
        this.writer = outputWriter;
    }

    abstract Object getData();

    @Override
    public void run() {
        Object data = getData();
        writer.output(data);
    }
}
