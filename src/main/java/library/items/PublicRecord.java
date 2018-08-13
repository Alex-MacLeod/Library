package library.items;

public class PublicRecord extends Item {

    private final boolean digitised;
    private final RecordType type;

    private enum RecordType {
        BIRTH, MARRIAGE, DEATH, PLANNING, MEETING
    }

    public PublicRecord(String name, String author, int yearPublished, boolean digitised, String type) {
        super(name, author, yearPublished);
        this.digitised = digitised;
        this.type = RecordType.valueOf(type);
    }

    public boolean isDigitised() {
        return digitised;
    }

    public RecordType getType() {
        return type;
    }
}
