package be.reneald.api.customers;

import be.reneald.domain.customers.Customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerMapper {
    private AddressMapper addressMapper;

    @Inject
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDto toDto(Customer customer) {
        return CustomerDto.customerDto()
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmail(customer.getEmail())
                .withPhone(customer.getPhone())
                .withAddressDto(addressMapper.toDto(customer.getAddress()))
                .withCustomerId(customer.getCustomerId());
    }

    public Customer toDomain(CustomerDto customerDto) {
        return Customer.CustomerBuilder.customer()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withEmail(customerDto.getEmail())
                .withPhone(customerDto.getPhone())
                .withAddress(addressMapper.toDomain(customerDto.getAddressDto()))
                .build();
    }
}
