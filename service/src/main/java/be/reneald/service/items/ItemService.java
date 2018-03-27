package be.reneald.service.items;

import be.reneald.domain.items.Item;
import be.reneald.domain.items.ItemRepository;
import be.reneald.domain.orders.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class ItemService {
    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    @Inject
    public ItemService(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public Item addItem(Item itemToAdd) throws IllegalArgumentException {
        if (itemToAdd.getItemId() != 0) {
            throw new IllegalArgumentException("New item cannot have an ID.");
        }
        itemRepository.addItem(itemToAdd);
        return itemToAdd;
    }

    public Item updateItem(Item itemToUpdate) {
        return itemRepository.updateItem(itemToUpdate);
    }

    public Map<Item.StockResupplyUrgency, List<Item>> getItemsOrderedByResupplyUrgency() {
        return new TreeMap<>(itemsByResupplyUrgency());
    }

    private Map<Item.StockResupplyUrgency, List<Item>> itemsByResupplyUrgency() {
        return itemRepository.getRepository().values().stream()
                .peek(item -> item.setStockResupplyUrgency(calculateStockResupplyUrgency(item)))
                .collect(Collectors.groupingBy(Item::getStockResupplyUrgency));
    }

    private Item.StockResupplyUrgency calculateStockResupplyUrgency(Item item) {
        if (item.getAmount() < 3 || hasItemBeenOrderedInLast7Days(item)) {
            return Item.StockResupplyUrgency.STOCK_LOW;
        }
        if (item.getAmount() < 10) {
            return Item.StockResupplyUrgency.STOCK_MEDIUM;
        }
        return Item.StockResupplyUrgency.STOCK_HIGH;
    }

    private boolean hasItemBeenOrderedInLast7Days(Item item) {
        return orderRepository.getRepository().values().stream()
                .filter(order -> order.getOrderDate().plusDays(7).isAfter(LocalDate.now().minusDays(1)))
                .filter(order -> order.getItems().stream()
                        .anyMatch(itemGroup -> itemGroup.getItem().equals(item)))
                .count() > 1;
    }
}
