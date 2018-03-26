package be.reneald.domain.orders;

import java.time.LocalDate;

public enum ShippingStatus {
    IN_STOCK (LocalDate.now().plusDays(1)),
    OUT_OF_STOCK (LocalDate.now().plusWeeks(1));

    private LocalDate shippingTimeByStock;

    ShippingStatus(LocalDate date) {
        this.shippingTimeByStock = date;
    }

    public LocalDate getShippingTimeByStock() {
        return shippingTimeByStock;
    }
}
