package be.reneald.api.orders;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;

@Named
public class OrderReport {
    private int customerId;
    private List<OrderDto> orders;
    private BigDecimal totalPrice;

    public OrderReport(int customerId, List<OrderDto> orders) {
        this.customerId = customerId;
        this.orders = orders;
        this.totalPrice = calculateTotalPrice();
    }

    private BigDecimal calculateTotalPrice() {
        return orders.stream()
                .map(OrderDto::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
