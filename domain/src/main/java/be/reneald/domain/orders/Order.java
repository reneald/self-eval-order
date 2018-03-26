package be.reneald.domain.orders;

import be.reneald.domain.customers.Customer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Order {
    private List<ItemGroup> items;
    private BigDecimal totalPrice;
    private Customer customer;
    private int orderId;

    public Order(Customer customer, ItemGroup... items) {
        this.customer = customer;
        this.items = Arrays.asList(items);
        updateTotalPrice();
    }

    public void addItemGroup(ItemGroup itemGroup) {
        items.add(itemGroup);
        updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private void updateTotalPrice() {
        BigDecimal newTotalPrice = BigDecimal.ZERO;
        for (ItemGroup item : items) {
            newTotalPrice = newTotalPrice.add(item.calculatePrice());
        }
        this.totalPrice = newTotalPrice;
    }
}
