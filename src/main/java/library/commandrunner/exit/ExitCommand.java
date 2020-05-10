package library.commandrunner.exit;

import library.commandrunner.LibraryCommand;

public class ExitCommand implements LibraryCommand {

    @Override
    public void run() {
        System.out.println("Quitting library system");
    }
}
