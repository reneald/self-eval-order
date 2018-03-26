package be.reneald.service.customers;

import be.reneald.domain.customers.Customer;
import be.reneald.domain.customers.CustomerRepository;
import be.reneald.service.exceptions.ExistingEmailException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
public class CustomerService {
    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) throws IllegalArgumentException {
        if (customer.getCustomerId() != 0) {
            throw new IllegalArgumentException("A new customer cannot have a Customer ID.");
        }
        if (customerRepository.isEmailKnown(customer.getEmail())) {
            throw new ExistingEmailException("A customer with that e-mail address is already in the database.");
        }

        return customerRepository.addCustomer(customer);
    }

    public Map<Integer, Customer> getCustomerRepository() {
        return customerRepository.getRepository();
    }

}
