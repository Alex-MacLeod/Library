package library.commandrunner.output;

class OutputInvalidCommandRunner implements OutputCommandRunner {

    String invalidCommand;

    public OutputInvalidCommandRunner(String invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    @Override
    public void run() {
        System.out.println("Did not recognise '" + invalidCommand + "' as a valid output type");
    }
}
