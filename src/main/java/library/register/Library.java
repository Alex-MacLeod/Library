package library.register;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.item.Item;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {

    private static volatile List<Item> itemsLibrary;

    public static List<Item> getLibrary() {
        if (itemsLibrary == null) {
            synchronized (Library.class) {
                if(itemsLibrary == null){
                    ObjectMapper mapper = new ObjectMapper();
                    try (InputStream is = Library.class.getResourceAsStream("/library.json");) {
                        itemsLibrary = mapper.readValue(is, new TypeReference<List<Item>>() {});
                        System.out.println("Library initialised"); // debug
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
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
