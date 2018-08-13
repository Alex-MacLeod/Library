package library.items;

public class Magazine extends Item {

    private final int issueNumber;

    public Magazine(String name, String author, int yearPublished, int issueNumber) {
        super(name, author, yearPublished);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
