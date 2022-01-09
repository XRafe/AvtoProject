package avtoproject.service.impl;

import avtoproject.dto.order.OrderCreateDto;
import avtoproject.dto.order.OrderDto;
import avtoproject.entity.OrderAvto;
import avtoproject.repository.OrderRepository;
import avtoproject.service.OrderService;
import avtoproject.service.factory.OrderFactory;
import avtoproject.service.mapper.OrderMapper;
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
                orderCreateDto.getModelId(),
                orderCreateDto.getUserId()
        );
        order = orderRepository.saveAndFlush(order);

        return orderMapper.mapOrderDto(order);
    }


}
