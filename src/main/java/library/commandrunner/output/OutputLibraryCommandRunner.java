package library.commandrunner.output;

import library.register.Library;
import library.commandrunner.io.writer.OutputWriter;

class OutputLibraryCommandRunner extends OutputCommandRunner {

    // TODO: Create tests

    public OutputLibraryCommandRunner(OutputWriter outputWriter) {
        super(outputWriter);
    }

    @Override
    Object getData() {
        return Library.getLibrary();
    }
}
