package be.reneald.service.orders;

import be.reneald.domain.orders.Order;
import be.reneald.domain.orders.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
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
}
