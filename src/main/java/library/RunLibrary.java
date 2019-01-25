package library;

import library.command.Command;
import library.util.Input;

import java.util.Arrays;
import java.util.List;

import static library.command.Command.commandMap;

public class RunLibrary {

    public static void main(String[] args) {

        boolean isExited = false;

        do {
            System.out.println("Next command:");
            String commandInput = Input.scan.nextLine();
            List<String> commands = Arrays.asList(commandInput.split(" "));
            Command.Commands initialCommand;
            try {
                initialCommand = Command.Commands.valueOf(commands.get(0).toUpperCase());
            } catch (IllegalArgumentException ie) {
                initialCommand = Command.Commands.UNKNOWN;
            }

            commandMap.get(initialCommand).accept(commands);

            if (Command.Commands.EXIT.equals(initialCommand)) {
                isExited = true;
            }

        } while (!isExited);

        Input.scan.close();

    }
}
