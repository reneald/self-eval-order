package be.reneald.domain.customers;

public class Address {
    private String streetName;
    private String houseNumber;
    private String postCode;
    private String city;

    private Address() {

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

    public static class AddressBuilder {
        private String streetName;
        private String houseNumber;
        private String postCode;
        private String city;

        public static AddressBuilder address() {
            return new AddressBuilder();
        }

        public Address build() {
            Address newAddress = new Address();
            newAddress.streetName = streetName;
            newAddress.houseNumber = houseNumber;
            newAddress.postCode = postCode;
            newAddress.city = city;
            return null;
        }

        public AddressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }
    }
}
