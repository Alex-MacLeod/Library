package library.commandrunner.output;

import library.commandrunner.LibraryCommand;
import library.io.writer.OutputWriter;

abstract class OutputCommand implements LibraryCommand {

    private final OutputWriter writer;

    public OutputCommand(OutputWriter outputWriter) {
        this.writer = outputWriter;
    }

    OutputWriter getWriter() {
        return writer;
    }

    abstract Object getData();

    @Override
    public void run() {
        Object data = getData();
        writer.output(data);
    }
}
