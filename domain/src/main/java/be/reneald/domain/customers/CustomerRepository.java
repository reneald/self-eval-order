package be.reneald.domain.customers;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class CustomerRepository {
    private Map<Integer, Customer> repository;
    private int customerIdCounter;

    public CustomerRepository() {
        repository = new HashMap<>();
        customerIdCounter = 1;
    }

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(customerIdCounter);
        repository.put(customerIdCounter++, customer);
        return customer;
    }

    public Map<Integer, Customer> getRepository() {
        return Collections.unmodifiableMap(repository);
    }

    public int getCustomerIdCounter() {
        return customerIdCounter;
    }

    public boolean isEmailKnown(String email) {
        boolean affirmative = false;
        for (Customer customer : repository.values()) {
            if (customer.getEmail().equals(email)) {
                affirmative = true;
            }
        }
        return affirmative;
    }
}
