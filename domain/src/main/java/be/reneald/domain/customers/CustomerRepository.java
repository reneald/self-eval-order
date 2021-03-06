package be.reneald.domain.customers;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class CustomerRepository {
    private Map<Integer, Customer> repository;
    private int customerIdCounter;

    CustomerRepository() {
        repository = new HashMap<>();
        customerIdCounter = 1;
    }

    public Customer addCustomer(Customer customerToAdd) {
        customerToAdd.setCustomerId(customerIdCounter);
        repository.put(customerIdCounter++, customerToAdd);
        return customerToAdd;
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
