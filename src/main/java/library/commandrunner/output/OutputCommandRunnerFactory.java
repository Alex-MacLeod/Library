package library.commandrunner.output;

import library.writer.ConsoleWriter;
import library.writer.FileWriter;
import library.writer.OutputWriter;

import java.util.List;

public class OutputCommandRunnerFactory {

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
            return new OutputInvalidCommandRunner(dataTypeToBeOutputted);
        }
    }
}
