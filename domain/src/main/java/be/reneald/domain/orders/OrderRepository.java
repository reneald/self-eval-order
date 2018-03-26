package be.reneald.domain.orders;

import be.reneald.domain.customers.Customer;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
public class OrderRepository {
    private Map<Integer, Order> repository;
    private int orderIdCounter;

    public OrderRepository() {
        repository = new HashMap<>();
        orderIdCounter = 0;
    }

    public Map<Integer, Order> getRepository() {
        return Collections.unmodifiableMap(repository);
    }

    public Order addOrder(Order orderToAdd) {
        orderToAdd.setOrderId(orderIdCounter++);
        return repository.put(orderToAdd.getOrderId(), orderToAdd);
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        return repository.entrySet().stream()
                .filter(entry -> entry.getValue().getCustomer().getCustomerId() == customerId)
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }
}
