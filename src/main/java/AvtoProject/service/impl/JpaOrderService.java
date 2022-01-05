package AvtoProject.service.impl;

import AvtoProject.dto.Order.OrderCreateDto;
import AvtoProject.dto.Order.OrderDto;
import AvtoProject.dto.Order.OrderEditDto;
import AvtoProject.entity.OrderAvto;
import AvtoProject.repository.OrderRepository;
import AvtoProject.service.OrderService;
import AvtoProject.service.factory.OrderFactory;
import AvtoProject.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaOrderService implements OrderService {
    public JpaOrderService(OrderFactory orderFactory,
                           OrderRepository orderRepository,
                           OrderMapper orderMapper) {
        this.orderFactory = orderFactory;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    private final OrderFactory orderFactory;

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;
    @Override
    public List<OrderDto> getList() {
        List<OrderAvto> orders = orderRepository.findAll();
        return orderMapper.mapOrderDto(orders);
    }

    @Transactional
    @Override
    public OrderDto createOrder(OrderCreateDto orderCreateDto) {
        OrderAvto order = orderFactory.build(
          orderCreateDto.getCount(),
          orderCreateDto.getSum(),
                orderCreateDto.getModel_id(),
                orderCreateDto.getUser_id()
        );
        order = orderRepository.saveAndFlush(order);

        return orderMapper.mapOrderDto(order);
    }


}
