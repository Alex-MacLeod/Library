package library;

import library.commands.LibraryCommand;
import library.commands.LibraryCommand.Command;
import library.util.Input;

import java.util.Arrays;
import java.util.List;

public class RunLibrary {

    public static void main(String[] args) {

        boolean isExited = false;

        do {
            System.out.println("Next command:");
            String commandInput = Input.scan.nextLine();
            List<String> commands = Arrays.asList(commandInput.split(" "));
            Command initialCommand;
            try {
                initialCommand = Command.valueOf(commands.get(0).toUpperCase());
            } catch (IllegalArgumentException ie) {
                System.out.println("Did not recognise command \"" + commands.get(0) + "\". Use the \"help\" " +
                        "command to see list of valid commands");
                continue;
            }

            LibraryCommand.execute(initialCommand, commands);

            if (Command.EXIT.equals(initialCommand)) {
                isExited = true;
            }

        } while (!isExited);

        Input.scan.close();
    }
}
