package library.commandrunner.output;

class OutputInvalidCommandRunner implements OutputCommandRunner {

    private final String invalidDataType;

    public OutputInvalidCommandRunner(String invalidDataType) {
        this.invalidDataType = invalidDataType;
    }

    @Override
    public void run() {
        System.out.println("Did not recognise '" + invalidDataType + "' as a valid data type to be outputted");
    }
}
