package be.reneald.domain.orders;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
}
