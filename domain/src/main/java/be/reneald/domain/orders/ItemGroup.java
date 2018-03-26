package be.reneald.domain.orders;

import be.reneald.domain.items.Item;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private ShippingStatus shippingStatus;

    public ItemGroup(Item item, int amount) {
        this.amount = amount;
        this.item = Item.ItemBuilder.item()
                .withItemId(item.getItemId())
                .withItemName(item.getItemName())
                .withItemDescription(item.getItemDescription())
                .withAmount(item.getAmount())
                .withPrice(item.getPrice())
                .build();
        setShippingStatus();
        this.shippingDate = calculateShippingDate();
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    private LocalDate calculateShippingDate() {
        return shippingStatus.getShippingTimeByStock();
    }

    private void setShippingStatus() {
        shippingStatus = isThisItemOutOfStock() ? ShippingStatus.OUT_OF_STOCK : ShippingStatus.IN_STOCK;
    }

    private boolean isThisItemOutOfStock(){
        return (this.amount < item.getAmount());
    }

    public BigDecimal calculatePrice() {
        return item.getPrice().multiply(BigDecimal.valueOf(amount));
    }


}
