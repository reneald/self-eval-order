package be.reneald.api.items;

import be.reneald.domain.items.Item;
import be.reneald.service.items.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private ItemService itemService;
    private ItemMapper itemMapper;

    @Inject
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        Item tempItem = itemMapper.toDomain(itemDto);
        Item serviceItem = itemService.addItem(tempItem);
        return itemMapper.toDto(serviceItem);
    }
}
