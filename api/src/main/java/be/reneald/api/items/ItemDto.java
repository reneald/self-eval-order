package be.reneald.api.items;

import java.math.BigDecimal;

public class ItemDto {
    private int itemId;
    private String itemName;
    private String itemDescription;
    private double price;
    private int amount;

    public static ItemDto itemDto() {
        return new ItemDto();
    }

    public ItemDto withItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemDto withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ItemDto withItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public ItemDto withPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
