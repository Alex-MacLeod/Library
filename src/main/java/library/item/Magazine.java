package library.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Magazine extends Item {

    private final int issueNumber;

    @JsonCreator
    public Magazine(@JsonProperty("name")String name,
                    @JsonProperty("author")String author,
                    @JsonProperty("yearPublished")int yearPublished,
                    @JsonProperty("issueNumber")int issueNumber) {
        super(name, author, yearPublished);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
