package library.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicRecord extends Item {

    private final boolean digitised;
    private final RecordType recordType;

    private enum RecordType {
        BIRTH, MARRIAGE, DEATH, PLANNING, MEETING
    }

    @JsonCreator
    public PublicRecord(@JsonProperty("name")String name,
                        @JsonProperty("author")String author,
                        @JsonProperty("yearPublished")int yearPublished,
                        @JsonProperty("digitised")boolean digitised,
                        @JsonProperty("recordType")String recordType) {
        super(name, author, yearPublished);
        this.digitised = digitised;
        this.recordType = RecordType.valueOf(recordType.toUpperCase());
    }

    public boolean isDigitised() {
        return digitised;
    }

    public RecordType getRecordType() {
        return recordType;
    }
}
