package be.reneald.api.items;

import be.reneald.domain.items.Item;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemMapper {
    public ItemDto toDto(Item item) {
        return ItemDto.itemDto()
                .withItemId(item.getItemId())
                .withItemName(item.getItemName())
                .withItemDescription(item.getItemDescription())
                .withPrice(item.getPrice().doubleValue())
                .withAmount(item.getAmount());
    }

    public Item toDomain(ItemDto itemDto) {
        return Item.ItemBuilder.item()
                .withItemName(itemDto.getItemName())
                .withItemDescription(itemDto.getItemDescription())
                .withPrice(BigDecimal.valueOf(itemDto.getPrice()))
                .withAmount(itemDto.getAmount())
                .build();
    }
}
