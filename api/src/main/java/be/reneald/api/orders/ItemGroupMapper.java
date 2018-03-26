package be.reneald.api.orders;

import be.reneald.api.items.ItemMapper;
import be.reneald.domain.items.ItemRepository;
import be.reneald.domain.orders.ItemGroup;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemGroupMapper {
    private ItemMapper itemMapper;
    private ItemRepository itemRepository;

    @Inject
    public ItemGroupMapper(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return ItemGroupDto.itemGroupDto()
                .withItemId(itemGroup.getItem().getItemId())
                .withAmount(itemGroup.getAmount())
                .withDate(itemGroup.getShippingDate());
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        return new ItemGroup(itemRepository.getRepository().get(itemGroupDto.getItemId()), itemGroupDto.getAmount());
    }
}
