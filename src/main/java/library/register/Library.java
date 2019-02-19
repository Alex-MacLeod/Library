package library.register;

import library.item.Item;
import library.util.JSONConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {

    private static final Object mutex = new Object();
    private static volatile List<Item> itemsLibrary;

    public static List<Item> getLibrary() {
        List<Item> result = itemsLibrary;
        if (result == null) {
            synchronized (mutex) {
                result = itemsLibrary;
                if(result == null){
                    itemsLibrary = result = JSONConverter.readJsonList("/library.json", Item.class);
                }
            }
        }
        return result;
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
