package AvtoProject.service.mapper;

import AvtoProject.dto.Order.OrderDto;
import AvtoProject.entity.OrderAvto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto mapOrderDto(OrderAvto model) {
        return new OrderDto(
                model.getId(),
                model.getCount(),
                model.getSum(),
                model.getModel_id(),
                model.getUser_id()
        );
    }

    public List<OrderDto> mapOrderDto(Collection<OrderAvto> model) {
        return model.stream()
                .map(this::mapOrderDto)
                .collect(Collectors.toList());
    }
}
