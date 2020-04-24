package library.commandrunner.output;

import library.io.writer.ConsoleWriter;
import library.io.writer.FileWriter;
import library.io.writer.OutputWriter;

import java.util.List;

public class OutputCommandRunnerFactory {

    // TODO: Create tests

    private OutputCommandRunnerFactory() {}

    public static OutputCommandRunner getOutputCommandRunner(List<String> commandStrings) {
        OutputWriter writer;
        // Default to writing output to console
        String outputWriterType = commandStrings.size() > 2 ?commandStrings.get(2) : "console";
        if ("console".equals(outputWriterType)) {
            writer = new ConsoleWriter();
        } else if ("file".equals(outputWriterType)) {
            writer = new FileWriter();
        } else {
            throw new IllegalArgumentException("Invalid output writer");
        }

        String dataTypeToBeOutputted = commandStrings.get(1);
        if ("library".equals(dataTypeToBeOutputted)) {
            return new OutputLibraryCommandRunner(writer);
        } else if ("customers".equals(dataTypeToBeOutputted)) {
            return new OutputCustomersCommandRunner(writer);
        } else {
            throw new IllegalArgumentException("Did not recognise '" + dataTypeToBeOutputted + "' as a valid data type to be outputted");
        }
    }
}
