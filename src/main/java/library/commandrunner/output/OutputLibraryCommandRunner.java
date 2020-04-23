package library.commandrunner.output;

import library.item.Item;
import library.register.Library;
import library.writer.OutputWriter;

import java.util.List;

class OutputLibraryCommandRunner implements OutputCommandRunner {

    private final OutputWriter writer;

    public OutputLibraryCommandRunner(OutputWriter outputWriter) {
        this.writer = outputWriter;
    }

    @Override
    public void run() {
        List<Item> list = Library.getLibrary();
        writer.output(list);
    }
}
