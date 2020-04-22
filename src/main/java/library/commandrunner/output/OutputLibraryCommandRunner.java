package library.commandrunner.output;

import library.item.Item;
import library.register.Library;
import library.util.JSONConverter;

import java.util.List;

class OutputLibraryCommandRunner implements OutputCommandRunner {

    @Override
    public void run() {
        List<Item> list = Library.getLibrary();
        JSONConverter.outputJson(list);
    }
}
