package be.reneald.api.orders;

import be.reneald.api.items.ItemDto;

import java.time.LocalDate;

public class ItemGroupDto {
    private int itemId;
    private int amount;
    private int shippingDay;
    private int shippingMonth;
    private int shippingYear;

    public static ItemGroupDto itemGroupDto() {
        return new ItemGroupDto();
    }


    public ItemGroupDto withItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemGroupDto withDate(LocalDate shippingDate) {
        this.shippingDay = shippingDate.getDayOfMonth();
        this.shippingMonth = shippingDate.getMonthValue();
        this.shippingYear = shippingDate.getYear();
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
