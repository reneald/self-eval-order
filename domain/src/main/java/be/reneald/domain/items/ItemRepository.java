package be.reneald.domain.items;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class ItemRepository {
    private Map<Integer, Item> repository;
    private int itemIdCounter;

    public ItemRepository() {
        repository = new HashMap<>();
        itemIdCounter = 1;
    }

    public Map<Integer, Item> getRepository() {
        return Collections.unmodifiableMap(repository);
    }

    public Item addItem(Item itemToAdd) {
        itemToAdd.setItemId(itemIdCounter++);
        return repository.put(itemToAdd.getItemId(), itemToAdd);
    }
}
