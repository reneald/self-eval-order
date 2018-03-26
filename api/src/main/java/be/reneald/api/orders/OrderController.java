package be.reneald.api.orders;

import be.reneald.api.customers.AddressDto;
import be.reneald.api.customers.AddressMapper;
import be.reneald.service.orders.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private OrderMapper orderMapper;
    private ItemGroupMapper itemGroupMapper;
    private OrderService orderService;
    private AddressMapper addressMapper;

    @Inject
    public OrderController(OrderMapper orderMapper, ItemGroupMapper itemGroupMapper, OrderService orderService, AddressMapper addressMapper) {
        this.orderMapper = orderMapper;
        this.itemGroupMapper = itemGroupMapper;
        this.orderService = orderService;
        this.addressMapper = addressMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderDto placeOrder(@RequestBody OrderDto orderDtoToPlace) {
        return orderMapper.toDto(orderService.addOrder(orderMapper.toDomain(orderDtoToPlace)));
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderReport getOrdersByCustomer(@RequestParam(value = "customerId") int customerId) {
        List<OrderDto> orderDtoList = orderService.getOrdersByCustomer(customerId).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
        return new OrderReport(customerId, orderDtoList);
    }

    @PostMapping(path = "/{orderId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderDto reOrder(@PathVariable int orderId) {
        return orderMapper.toDto(orderService.reOrder(orderId));
    }

    @GetMapping(path = "/shippingtoday", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<ItemGroupDto, AddressDto> getItemsShippingTodayWithAddress() {
        Map<ItemGroupDto, AddressDto> itemsToShip = new HashMap<>();
        return orderService.getItemsShippingOnGivenDateWithAddress(LocalDate.now()).entrySet().stream()
                .collect(Collectors.toMap(entry -> itemGroupMapper.toDto(entry.getKey()), entry -> addressMapper.toDto(entry.getValue())));
    }
}
