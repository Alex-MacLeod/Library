package library.commandrunner;

import library.commandrunner.add.AddCommandRunner;
import library.commandrunner.exit.ExitCommandRunner;
import library.commandrunner.extend.ExtendCommandRunner;
import library.commandrunner.help.HelpCommandRunner;
import library.commandrunner.loan.LoanCommandRunner;
import library.commandrunner.output.OutputCommandRunnerFactory;
import library.commandrunner.remove.RemoveCommandRunner;
import library.commandrunner.returnitem.ReturnCommandRunner;
import library.commandrunner.update.UpdateCommandRunner;

import java.util.List;

public interface LibraryCommandRunner extends Runnable {

    static void run(Command mainCommand, List<String> commandStrings) {
        LibraryCommandRunner command = switch (mainCommand) {
            case ADD -> new AddCommandRunner(commandStrings);
            case EXIT -> new ExitCommandRunner();
            case EXTEND -> new ExtendCommandRunner(commandStrings);
            case HELP -> new HelpCommandRunner();
            case LOAN -> new LoanCommandRunner(commandStrings);
            case OUTPUT -> OutputCommandRunnerFactory.getOutputCommandRunner(commandStrings);
            case REMOVE -> new RemoveCommandRunner(commandStrings);
            case RETURN -> new ReturnCommandRunner(commandStrings);
            case UPDATE -> new UpdateCommandRunner(commandStrings);
        };
        command.run();
    }

    enum Command {
        ADD, EXIT, EXTEND, HELP, LOAN, OUTPUT, REMOVE, RETURN, UPDATE
    }
}
