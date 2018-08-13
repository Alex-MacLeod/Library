package library.items;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Item {

    private final String name;
    private final UUID iD;
    private final String author;
    private final int yearPublished;
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

    public UUID getiD() {
        return iD;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isOnLoan() {
        return onLoan;
    }
}
