package be.reneald.api.orders;

import be.reneald.api.customers.CustomerDto;
import be.reneald.domain.orders.Order;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private List<ItemGroupDto> itemsDto;
    private BigDecimal totalPrice;
    private CustomerDto customerDto;
    private int orderId;

    public static OrderDto orderDto() {
        return new OrderDto();
    }

    public OrderDto withItemsDto(List<ItemGroupDto> itemsDto) {
        this.itemsDto = itemsDto;
        return this;
    }

    public OrderDto withTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderDto withCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

    public OrderDto withOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<ItemGroupDto> getItemsDto() {
        return itemsDto;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public int getOrderId() {
        return orderId;
    }
}
