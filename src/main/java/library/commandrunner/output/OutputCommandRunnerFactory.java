package library.commandrunner.output;

import library.io.writer.ConsoleWriter;
import library.io.writer.FileWriter;
import library.io.writer.OutputWriter;

import java.util.List;

public class OutputCommandRunnerFactory {

    private OutputCommandRunnerFactory() {}

    public static OutputCommandRunner getOutputCommandRunner(List<String> commandStrings) {
        OutputWriter writer;
        String outputWriterType;
        String dataTypeToBeOutputted;

        if (commandStrings.size() > 1) {
            outputWriterType = commandStrings.get(0);
            dataTypeToBeOutputted = commandStrings.get(1);
        } else if (commandStrings.size() == 1) {
            // Default to writing output to console
            outputWriterType = "console";
            dataTypeToBeOutputted = commandStrings.get(0);
        } else {
            throw new IllegalArgumentException("Too few arguments");
        }

        // Set writer
        if ("console".equals(outputWriterType)) {
            writer = new ConsoleWriter();
        } else if ("file".equals(outputWriterType)) {
            writer = new FileWriter();
        } else {
            throw new IllegalArgumentException("Invalid output writer '" + outputWriterType + "'");
        }

        // Set data to be outputted
        if ("library".equals(dataTypeToBeOutputted)) {
            return new OutputLibraryCommandRunner(writer);
        } else if ("customers".equals(dataTypeToBeOutputted)) {
            return new OutputCustomersCommandRunner(writer);
        } else {
            throw new IllegalArgumentException("Did not recognise '" + dataTypeToBeOutputted + "' as a valid data type to be outputted");
        }
    }
}
