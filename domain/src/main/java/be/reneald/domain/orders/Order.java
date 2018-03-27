package be.reneald.domain.orders;

import be.reneald.domain.customers.Address;
import be.reneald.domain.customers.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<ItemGroup> items;
    private BigDecimal totalPrice;
    private Customer customer;
    private int orderId;
    private LocalDate orderDate;

    public Order(Customer customer, ItemGroup... items) {
        this.customer = customer;
        this.items = Arrays.asList(items);
        this.orderDate = LocalDate.now();
        Arrays.stream(items)
                .peek(itemGroup -> itemGroup.setOrderDate(orderDate))
                .close();
        updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItems() {
        return items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    private void updateTotalPrice() {
        BigDecimal newTotalPrice = BigDecimal.ZERO;
        for (ItemGroup item : items) {
            newTotalPrice = newTotalPrice.add(item.calculatePrice());
        }
        this.totalPrice = newTotalPrice;
    }

    public List<ItemGroup> getItemGroupsByShippingDate(LocalDate date) {
        return items.stream()
                .filter(itemGroup -> itemGroup.getShippingDate().isEqual(date))
                .collect(Collectors.toList());
    }

    public Address getShippingAddress() {
        return customer.getAddress();
    }
}
