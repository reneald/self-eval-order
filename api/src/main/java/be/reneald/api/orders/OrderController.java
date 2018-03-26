package be.reneald.api.orders;

import be.reneald.service.orders.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private OrderMapper orderMapper;
    private OrderService orderService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderDto placeOrder(@RequestBody OrderDto orderDtoToPlace) {
        return orderMapper.toDto(orderService.addOrder(orderMapper.toDomain(orderDtoToPlace)));
    }
}
