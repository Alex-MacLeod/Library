package library;

import library.util.Commands;
import library.util.Input;

import java.util.Arrays;

public class RunLibrary {

    public static void main(String[] args) {

        boolean isExited = false;

        do {
            System.out.println("Next command:");
            String commandInput = Input.scan.nextLine();
            String[] commands = commandInput.split(" ");
            Commands initialCommand;
            try {
                initialCommand = Commands.valueOf(commands[0].toUpperCase());
            } catch (IllegalArgumentException ie) {
                initialCommand = Commands.UNKNOWN;
            }

            switch (initialCommand) {
                case ADD:
                case EXIT:
                    System.out.println("Quitting library system");
                    isExited = true;
                    break;
                case EXTEND:
                case HELP:
                    System.out.println("Valid commands: " + Arrays.toString(Commands.values()).toLowerCase());
                    break;
                case LOAN:
                case REMOVE:
                case RETURN:
                case UPDATE:
                default:
                    System.out.println("Did not recognise command \"" + commands[0] + "\". Use the \"help\" " +
                            "command to see list of valid commands");
                    break;
            }
        } while (!isExited);

    }
}
