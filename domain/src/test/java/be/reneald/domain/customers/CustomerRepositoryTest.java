package be.reneald.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class CustomerRepositoryTest {

    private CustomerRepository testRepository;
    private Customer firstMockCustomer;

    @Before
    public void setUp() {
        testRepository = new CustomerRepository();
        firstMockCustomer = mock(Customer.class);
    }

    @Test
    public void addCustomer_happyPath_shouldAddCustomerToRepository() {
        testRepository.addCustomer(firstMockCustomer);

        assertThat(testRepository.getRepository().values()).contains(firstMockCustomer);
    }

    @Test
    public void addCustomer_happyPath_shouldReturnCustomer() {
        assertThat(testRepository.addCustomer(firstMockCustomer)).isEqualTo(firstMockCustomer);
    }

    @Test
    public void addCustomer_happyPath_shouldSetCustomerId() {
        doNothing().when(firstMockCustomer).setCustomerId(testRepository.getCustomerIdCounter());

        testRepository.addCustomer(firstMockCustomer);

        verify(firstMockCustomer, times(1)).setCustomerId(testRepository.getCustomerIdCounter() - 1);
    }

    @Test
    public void isEmailKnown_whenEmailAlreadyKnown_shouldReturnTrue() {
        when(firstMockCustomer.getEmail()).thenReturn("existingEmail");
        testRepository.addCustomer(firstMockCustomer);

        assertThat(testRepository.isEmailKnown("existingEmail")).isTrue();
    }

}