package be.reneald.service.items;

import be.reneald.domain.items.Item;
import be.reneald.domain.items.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemService {
    private ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item itemToAdd) throws  IllegalArgumentException {
        if (itemToAdd.getItemId() != 0) {
            throw new IllegalArgumentException("New item cannot have an ID.");
        }
        itemRepository.addItem(itemToAdd);
        return itemToAdd;
    }

    public Item updateItem(Item itemToUpdate) {
        return itemRepository.updateItem(itemToUpdate);
    }
}
