package be.reneald.api.customers;

import java.util.Objects;

public class AddressDto {
    private String streetName;
    private String houseNumber;
    private String postCode;
    private String city;

    public static AddressDto addressDto() {
        return new AddressDto();
    }

    public AddressDto withStreetName(String streetName){
        this.streetName = streetName;
        return this;
    }

    public AddressDto withHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressDto withPostCode(String postCode){
        this.postCode = postCode;
        return this;
    }

    public AddressDto withCity(String city){
        this.city = city;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(streetName, that.streetName) &&
                Objects.equals(houseNumber, that.houseNumber) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(streetName, houseNumber, postCode, city);
    }
}
