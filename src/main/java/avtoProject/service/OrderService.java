package avtoProject.service;

import avtoProject.dto.order.OrderCreateDto;
import avtoProject.dto.order.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getList();

    OrderDto createOrder(OrderCreateDto orderCreateDto);

}
