package be.reneald.domain.items;

import java.math.BigDecimal;

public class Item {
    private int itemId;
    private String itemName;
    private String itemDescription;
    private BigDecimal price;
    private int amount;
    private StockResupplyUrgency stockResupplyUrgency;

    private Item() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        amount = amount;
    }

    public enum StockResupplyUrgency{
        STOCK_LOW,
        STOCK_MEDIUM,
        STOCK_HIGH
    }

    public StockResupplyUrgency getStockResupplyUrgency() {
        return stockResupplyUrgency;
    }

    public void setStockResupplyUrgency(StockResupplyUrgency stockResupplyUrgency) {
        this.stockResupplyUrgency = stockResupplyUrgency;
    }

    public static class ItemBuilder {
        private int itemId;
        private String itemName;
        private String itemDescription;
        private BigDecimal price;
        private int amount;

        public static ItemBuilder item() {
            return new ItemBuilder();
        }

        public Item build() {
            Item newItem = new Item();
            newItem.itemId = itemId;
            newItem.itemName = itemName;
            newItem.itemDescription = itemDescription;
            newItem.price = price;
            newItem.amount = amount;
            return newItem;
        }

        public ItemBuilder withItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public ItemBuilder withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder withItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public ItemBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

    }

}
