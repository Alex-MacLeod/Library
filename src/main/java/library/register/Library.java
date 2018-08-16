package library.register;

import library.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {

    private static List<Item> itemsLibrary = new ArrayList<>();

    public static List<Item> getLibrary() {
        return itemsLibrary;
    }

    public static Item find(UUID itemID) {
        for (Item item : itemsLibrary) {
            if (itemID.equals(item.getID())){
                return item;
            }
        }
        return null;
    }

    public static List<Item> find(String name) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : itemsLibrary) {
            if (name.equals(item.getName())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    private Library() {
    }
}
