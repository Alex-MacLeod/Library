package library.commandrunner.output;

import library.register.CustomerRegister;
import library.io.writer.OutputWriter;

class OutputCustomersCommandRunner extends OutputCommandRunner {

    // TODO: Create tests

    public OutputCustomersCommandRunner(OutputWriter outputWriter) {
        super(outputWriter);
    }

    @Override
    Object getData() {
        return CustomerRegister.getRegister();
    }
}
