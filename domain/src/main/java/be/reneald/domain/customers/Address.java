package be.reneald.domain.customers;

public class Address {
    private String streetName;
    private String houseNumber;
    private String postCode;
    private String city;

    private Address() {

    }

    private void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    private void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    private void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    private void setCity(String city) {
        this.city = city;
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

        public AddressBuilder withpostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }
    }
}
