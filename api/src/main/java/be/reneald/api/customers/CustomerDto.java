package be.reneald.api.customers;

public class CustomerDto {
    private String firstName, lastName, email, phone;
    private AddressDto addressDto;
    private int customerId;

    public static CustomerDto customerDto() {
        return new CustomerDto();
    }

    public CustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerDto withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public CustomerDto withCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public int getCustomerId() {
        return customerId;
    }
}
