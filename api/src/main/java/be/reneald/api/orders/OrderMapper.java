package be.reneald.api.orders;

import be.reneald.api.customers.CustomerMapper;
import be.reneald.domain.orders.ItemGroup;
import be.reneald.domain.orders.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class OrderMapper {
    private CustomerMapper customerMapper;
    private ItemGroupMapper itemGroupMapper;

    @Inject
    public OrderMapper(CustomerMapper customerMapper, ItemGroupMapper itemGroupMapper) {
        this.customerMapper = customerMapper;
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDto toDto(Order order) {
        List<ItemGroupDto> itemsDto = order.getItems().stream()
                .map(itemGroup -> itemGroupMapper.toDto(itemGroup))
                .collect(Collectors.toList());
        return OrderDto.orderDto()
                .withCustomerDto(customerMapper.toDto(order.getCustomer()))
                .withOrderId(order.getOrderId())
                .withTotalPrice(order.getTotalPrice())
                .withItemsDto(itemsDto);
    }

    public Order toDomain(OrderDto orderDto) {
        ItemGroup[] itemGroups = orderDto.getItemsDto().stream()
                .map(itemGroupDto -> itemGroupMapper.toDomain(itemGroupDto))
                .toArray(ItemGroup[]::new);
        return new Order(customerMapper.toDomain(orderDto.getCustomerDto()), itemGroups);
    }
}
