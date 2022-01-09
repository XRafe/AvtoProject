package avtoproject.service;

import avtoproject.dto.order.OrderCreateDto;
import avtoproject.dto.order.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getList();

    OrderDto createOrder(OrderCreateDto orderCreateDto);

}
