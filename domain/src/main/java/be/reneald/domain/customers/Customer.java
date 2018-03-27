package be.reneald.domain.customers;

public class Customer {
    private String firstName, lastName, email, phone;
    private Address address;
    private int customerId;

    private Customer() {

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

        public static CustomerBuilder customer() {
            return new CustomerBuilder();
        }

        public Customer build() {
            Customer newCustomer = new Customer();

            newCustomer.firstName = firstName;
            newCustomer.lastName = lastName;
            newCustomer.email = email;
            newCustomer.phone = phone;
            newCustomer.address = address;

            return newCustomer;
        }

        public CustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }
    }
}
