package AvtoProject.service;

import AvtoProject.dto.Order.OrderCreateDto;
import AvtoProject.dto.Order.OrderDto;
import AvtoProject.dto.Order.OrderEditDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getList();

    OrderDto createOrder(OrderCreateDto orderCreateDto);

}
