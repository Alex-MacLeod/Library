package library.item;

public class ItemFactory {

    private static Item createItem(String type, String name, String author, int year) {
        return switch (type.toLowerCase()) {
            case "book" -> new Book(name, author, year, false, false);
            case "magazine" -> new Magazine(name, author, year, 0);
            case "public record" -> new PublicRecord(name, author, year, false, "birth");
            default -> throw new IllegalArgumentException("Invalid item type");
        };
    }
}
