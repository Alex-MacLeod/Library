package library.commandrunner;

import library.commandrunner.add.AddCommandFactory;
import library.commandrunner.exit.ExitCommand;
import library.commandrunner.extend.ExtendCommand;
import library.commandrunner.help.HelpCommand;
import library.commandrunner.loan.LoanCommand;
import library.commandrunner.output.OutputCommandFactory;
import library.commandrunner.remove.RemoveCommand;
import library.commandrunner.returnitem.ReturnCommand;
import library.commandrunner.update.UpdateCommand;

import java.util.List;

public interface LibraryCommand extends Runnable {

    // TODO: Create tests
    // TODO: Implement thread executor to run commands

    static void run(Command mainCommand, List<String> commandStrings) {
        commandStrings.remove(0);
        LibraryCommand command = switch (mainCommand) {
            case ADD -> AddCommandFactory.getAddCommand(commandStrings);
            case EXIT -> new ExitCommand();
            case EXTEND -> new ExtendCommand(commandStrings);
            case HELP -> new HelpCommand();
            case LOAN -> new LoanCommand(commandStrings);
            case OUTPUT -> OutputCommandFactory.getOutputCommand(commandStrings);
            case REMOVE -> new RemoveCommand(commandStrings);
            case RETURN -> new ReturnCommand(commandStrings);
            case UPDATE -> new UpdateCommand(commandStrings);
        };
        try {
            command.run();
        } catch (IllegalArgumentException | UnsupportedOperationException continueException) {
            System.err.println(continueException.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    enum Command {
        ADD, EXIT, EXTEND, HELP, LOAN, OUTPUT, REMOVE, RETURN, UPDATE
    }
}
