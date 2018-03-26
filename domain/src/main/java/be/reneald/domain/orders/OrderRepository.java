package be.reneald.domain.orders;

import be.reneald.domain.customers.Address;
import be.reneald.domain.customers.Customer;

import javax.inject.Named;
import java.time.LocalDate;
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

    public Order reOrder(Order orderToReOrder) {
        Order newOrder = new Order(orderToReOrder.getCustomer(), orderToReOrder.getItems().toArray(new ItemGroup[0]));
        addOrder(newOrder);
        return newOrder;
    }

    public Map<ItemGroup, Address> getItemsShippingOnGivenDateWithAddress(LocalDate date) {
        Map<ItemGroup, Address> itemGroupsShippingOnGivenDateWithAddress = new HashMap<>();
        for (Order order : repository.values()) {
            order.getItemGroupsByShippingDate(date).stream()
                    .map(itemGroup -> itemGroupsShippingOnGivenDateWithAddress.put(itemGroup, order.getShippingAddress()))
                    .close();
        }
        return itemGroupsShippingOnGivenDateWithAddress;
    }

    public Order getOrderById(int orderId) {
        return repository.get(orderId);
    }

    public boolean doesOrderIdExist(int orderId) {
        return orderId < orderIdCounter;
    }
}
