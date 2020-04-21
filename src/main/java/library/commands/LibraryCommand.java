package library.commands;

import java.util.List;

public interface LibraryCommand extends Runnable {

    static void execute(Command mainCommand, List<String> commandStrings) {
        LibraryCommand command = switch (mainCommand) {
            case ADD -> new AddCommand(commandStrings);
            case EXIT -> new ExitCommand();
            case EXTEND -> new ExtendCommand(commandStrings);
            case HELP -> new HelpCommand();
            case LOAN -> new LoanCommand(commandStrings);
            case OUTPUT -> new OutputCommand(commandStrings);
            case REMOVE -> new RemoveCommand(commandStrings);
            case RETURN -> new ReturnCommand(commandStrings);
            case UPDATE -> new UpdateCommand(commandStrings);
        };
        command.run();
    }

    enum Command {
        ADD, EXIT, EXTEND, HELP, LOAN, OUTPUT, REMOVE, RETURN, UPDATE
    }
}
