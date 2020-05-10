package library.commandrunner.output;

import library.register.CustomerRegister;
import library.io.writer.OutputWriter;

class OutputCustomersCommand extends OutputCommand {

    // TODO: Create tests

    public OutputCustomersCommand(OutputWriter outputWriter) {
        super(outputWriter);
    }

    @Override
    Object getData() {
        return CustomerRegister.getRegister();
    }
}
