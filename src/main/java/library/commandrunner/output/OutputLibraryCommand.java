package library.commandrunner.output;

import library.register.Library;
import library.io.writer.OutputWriter;

class OutputLibraryCommand extends OutputCommand {

    // TODO: Create tests

    public OutputLibraryCommand(OutputWriter outputWriter) {
        super(outputWriter);
    }

    @Override
    Object getData() {
        return Library.getLibrary();
    }
}
