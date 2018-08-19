package library.customer;

class Address {

    private String streetAddress;
    private String town;
    private String county;
    private String postCode;

    Address(String streetAddress, String postCode) {
        this.streetAddress = streetAddress;
        this.postCode = postCode;
    }

    Address(String streetAddress, String town, String postCode) {
        this.streetAddress = streetAddress;
        this.town = town;
        this.postCode = postCode;
    }

    Address(String streetAddress, String town, String county, String postCode) {
        this.streetAddress = streetAddress;
        this.town = town;
        this.county = county;
        this.postCode = postCode;
    }

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
