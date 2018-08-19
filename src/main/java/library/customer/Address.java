package library.customer;

class Address {

    private String streetAddress;
    private String town;
    private String county;
    private String postCode;

    String getStreetAddress() {
        return streetAddress;
    }

    void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    String getTown() {
        return town;
    }

    void setTown(String town) {
        this.town = town;
    }

    String getCounty() {
        return county;
    }

    void setCounty(String county) {
        this.county = county;
    }

    String getPostCode() {
        return postCode;
    }

    void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
