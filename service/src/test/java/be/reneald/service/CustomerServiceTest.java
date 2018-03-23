package be.reneald.service;

import be.reneald.domain.customers.Customer;
import be.reneald.domain.customers.CustomerRepository;
import be.reneald.service.customers.CustomerService;
import be.reneald.service.exceptions.ExistingEmailException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerServiceTest {
    private CustomerService testService;
    private CustomerRepository mockRepository;
    private Customer firstMockCustomer;

    @Before
    public void setUp() {
        mockRepository = mock(CustomerRepository.class);
        firstMockCustomer = mock(Customer.class);
        testService = new CustomerService(mockRepository);
    }

    @Test
    public void addCustomer_happyPath_shouldCallRepoAddUserMethod() {
        when(mockRepository.addCustomer(firstMockCustomer)).thenReturn(firstMockCustomer);

        testService.addCustomer(firstMockCustomer);

        verify(mockRepository, times(1)).addCustomer(firstMockCustomer);

    }

    @Test
    public void addCustomer_happyPath_shouldReturnCustomer() {
        when(mockRepository.addCustomer(firstMockCustomer)).thenReturn(firstMockCustomer);

        Assertions.assertThat(testService.addCustomer(firstMockCustomer)).isEqualTo(firstMockCustomer);
    }

    @Test
    public void addCustomer_whenEmailAlreadyInDatabase_shouldThrowException() {
        when(firstMockCustomer.getEmail()).thenReturn("existingEmail");
        when(mockRepository.isEmailKnown(firstMockCustomer.getEmail())).thenReturn(true);

        Assertions.assertThatExceptionOfType(ExistingEmailException.class)
                .isThrownBy(() -> testService.addCustomer(firstMockCustomer))
                .withMessage("A customer with that e-mail address is already in the database.");
    }

    @Test
    public void addCustomer_whenCustomerAlreadyHasID_shouldThrowException() {
        when(firstMockCustomer.getCustomerId()).thenReturn(5);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testService.addCustomer(firstMockCustomer))
                .withMessage("A new customer cannot have a Customer ID.");
    }

}