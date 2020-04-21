package library.commands;

public class ExitCommand implements LibraryCommand{

    @Override
    public void run() {
        System.out.println("Quitting library system");
    }
}
