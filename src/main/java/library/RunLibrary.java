package library;

import library.util.Command;
import library.service.LibraryService;
import library.util.Input;

import java.util.Arrays;
import java.util.List;

public class RunLibrary {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();

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

            libraryService.commandMap().get(initialCommand).accept(commands);

            if (Command.EXIT.equals(initialCommand)) {
                isExited = true;
            }

        } while (!isExited);

        Input.scan.close();

    }
}
