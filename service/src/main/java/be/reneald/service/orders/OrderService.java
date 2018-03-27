package be.reneald.service.orders;

import be.reneald.domain.customers.Address;
import be.reneald.domain.orders.ItemGroup;
import be.reneald.domain.orders.Order;
import be.reneald.domain.orders.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Named
public class OrderService {
    private OrderRepository orderRepository;

    @Inject
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order orderToAdd) throws IllegalArgumentException {
        if (orderToAdd.getOrderId() != 0) {
            throw new IllegalArgumentException("New order cannot have an order ID.");
        }
        orderRepository.addOrder(orderToAdd);
        return orderToAdd;
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        return orderRepository.getOrdersByCustomer(customerId);
    }

    public Order reOrder(int orderIdToReorder) throws IllegalArgumentException {
        throwExceptionWhenOrderIsNotFound(orderIdToReorder);
        return orderRepository.reOrder(orderRepository.getOrderById(orderIdToReorder));
    }

    private void throwExceptionWhenOrderIsNotFound(int orderId) throws IllegalArgumentException {
        if (orderRepository.doesOrderIdExist(orderId)) {
            throw new IllegalArgumentException("Cannot find this order.");
        }
    }

    public Map<ItemGroup, Address> getItemsShippingOnGivenDateWithAddress(LocalDate date) {
        return orderRepository.getItemsShippingOnGivenDateWithAddress(date);
    }
}
