package be.reneald.api.items;

import be.reneald.service.items.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
        return itemMapper.toDto(itemService.addItem(itemMapper.toDomain(itemDto)));
    }

    @PutMapping(path = "/itemId", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem(@PathVariable int itemId, @RequestBody ItemDto itemDtoToUpdate) {
        return itemMapper.toDto(itemService.updateItem(itemMapper.toDomain(itemDtoToUpdate.withItemId(itemId))));
    }

    @GetMapping(path = "/resupply", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItemsByResupplyUrgency() {
        return itemService.getItemsOrderedByResupplyUrgency().values().stream()
                .flatMap(List::stream)
                .map(item -> itemMapper.toDto(item))
                .collect(Collectors.toList());
    }
}
