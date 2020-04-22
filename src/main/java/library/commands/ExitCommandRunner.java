package library.commands;

public class ExitCommandRunner implements LibraryCommandRunner {

    @Override
    public void run() {
        System.out.println("Quitting library system");
    }
}
