package library.commandrunner.add;

import library.item.Item;

import java.util.List;

class AddLibraryItemCommand extends AddCommand<Item> {

    public AddLibraryItemCommand(List<String> commandStrings) {
        super(commandStrings);
    }

    @Override
    Item createObjectToBeAdded() {
        return null;
    }

    @Override
    void addToRegister(Item object) {

    }
}
