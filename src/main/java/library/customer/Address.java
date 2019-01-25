package library.customer;

class Address {

    private String streetAddress;
    private String place;
    private String county;
    private String postCode;

    Address(String streetAddress, String postCode) {
        this.streetAddress = streetAddress;
        this.postCode = postCode;
    }

    Address(String streetAddress, String place, String postCode) {
        this.streetAddress = streetAddress;
        this.place = place;
        this.postCode = postCode;
    }

    Address(String streetAddress, String town, String county, String postCode) {
        this.streetAddress = streetAddress;
        this.place = place;
        this.county = county;
        this.postCode = postCode;
    }

    String getStreetAddress() {
        return streetAddress;
    }

    void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
