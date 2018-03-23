package be.reneald.api.customers;


import be.reneald.service.customers.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private CustomerService customerService;
    private CustomerMapper customerMapper;
}
