package be.reneald.domain.customers;

public class Customer {
    private String firstName, lastName, email, phone;
    private Address address;
    private int customerId;

    private Customer() {

    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private void setAddress(Address address) {
        this.address = address;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Address getAddress() {
        return address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public static class CustomerBuilder {
        private String firstName, lastName, email, phone;
        private Address address;
        private int customerId;

        public static CustomerBuilder customer() {
            return new CustomerBuilder();
        }

        public Customer build() {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(firstName);
            newCustomer.setLastName(lastName);
            newCustomer.setEmail(email);
            newCustomer.setPhone(phone);
            newCustomer.setAddress(address);
            newCustomer.setCustomerId(customerId);
            return newCustomer;
        }

        public CustomerBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public CustomerBuilder withPhone(String phone){
            this.phone = phone;
            return this;
        }

        public CustomerBuilder withAddress(Address address){
            this.address = address;
            return this;
        }

        public CustomerBuilder withCustomerId(int customerId){
            this.customerId = customerId;
            return this;
        }

    }
}
