package library.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class),
        @JsonSubTypes.Type(value = Magazine.class),
        @JsonSubTypes.Type(value = PublicRecord.class),
})
public abstract class Item {

    private String name;
    private final UUID id;
    private String author;
    private int yearPublished;
    boolean onLoan;
    LocalDate loanExpiryDate;

    Item (String name, String author, int year) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.author = author;
        this.yearPublished = year;
        this.onLoan = false;
        this.loanExpiryDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isOnLoan() {
        return onLoan;
    }
}
