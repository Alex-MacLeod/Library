package library.commandrunner.output;

import java.util.List;

public class OutputCommandRunnerFactory {

    private OutputCommandRunnerFactory() {}

    public static OutputCommandRunner getOutputCommandRunner(List<String> commandStrings) {
        String outputType = commandStrings.get(1);
        if ("library".equals(outputType)) {
            return new OutputLibraryCommandRunner();
        } else if ("customers".equals(outputType)) {
            return new OutputCustomersCommandRunner();
        } else {
            return new OutputInvalidCommandRunner(outputType);
        }
    }
}
