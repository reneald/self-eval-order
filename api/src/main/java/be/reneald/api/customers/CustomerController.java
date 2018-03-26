package be.reneald.api.customers;


import be.reneald.service.customers.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Inject
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto createAccount(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(customerService.addCustomer(customerMapper.toDomain(customerDto)));
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, CustomerDto> getAllCustomers() {
        return customerService.getCustomerRepository().entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> customerMapper.toDto(entry.getValue())));
    }
}
