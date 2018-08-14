package library.items;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Item {

    private String name;
    private final UUID iD;
    private String author;
    private int yearPublished;
    boolean onLoan;
    LocalDate loanExpiryDate;

    Item (String name, String author, int year) {
        this.name = name;
        this.iD = UUID.randomUUID();
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
        return iD;
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
