package library.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import library.util.Constant;
import library.item.Borrowable;
import library.io.reader.LocalDateDeserializer;
import library.io.writer.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    private String name;
    private String email;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private final UUID id;
    private Address address;
    private final List<Borrowable> itemsBorrowed;

    @JsonCreator
    Customer(@JsonProperty("name")String name,
             @JsonProperty("email")String email,
             @JsonProperty("dateOfBirth")LocalDate dateOfBirth,
             @JsonProperty("address")Address address) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.id = UUID.randomUUID();
        this.address = address;
        this.itemsBorrowed = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public UUID getId() {
        return this.id;
    }

    public Address getAddress() {
        return this.address;
    }

    public List<Borrowable> getItemsBorrowed() {
        return this.itemsBorrowed;
    }

    public Customer update(String name, String email, LocalDate dateOfBirth, Address address) {
        if (name != null) this.name = name;
        if (email != null) this.email = email;
        if (dateOfBirth != null) this.dateOfBirth = dateOfBirth;
        if (address != null) this.address = address;
        return this;
    }

    public void borrow(Borrowable item, long loanWeeks) {
        if (!item.isOnLoan()) {
            item.loan(this, loanWeeks);
            if (item.isOnLoan()) {
                this.itemsBorrowed.add(item);
            }
        } else {
            System.err.println("You cannot borrow this item, it is already on loan!");
        }
    }

    public void borrow(Borrowable item) {
        this.borrow(item, Constant.STANDARD_LOAN_PERIOD_WEEKS);
    }

    public void returnToLibrary(UUID itemID) {
        if (this.itemsBorrowed.isEmpty()) {
            System.err.println("Customer has not borrowed any books");
        } else {
            for (Borrowable item : this.itemsBorrowed) {
                if (itemID.equals(item.getID())) {
                    itemsBorrowed.remove(item);
                    item.returnFromLoan();
                    break;
                } else {
                    System.err.println("Customer has not borrowed this item, so cannot return it");
                }
            }
        }
    }
}
