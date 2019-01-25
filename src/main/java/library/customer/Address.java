package library.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonCreator
    Address(@JsonProperty("streetAddress")String streetAddress,
            @JsonProperty("place")String place,
            @JsonProperty("county")String county,
            @JsonProperty("postCode")String postCode) {
        this.streetAddress = streetAddress;
        this.place = place;
        this.county = county;
        this.postCode = postCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
