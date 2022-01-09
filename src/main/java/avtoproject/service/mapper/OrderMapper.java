package avtoproject.service.mapper;

import avtoproject.dto.order.OrderDto;
import avtoproject.entity.OrderAvto;
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
                model.getModelId(),
                model.getUserId()
        );
    }

    public List<OrderDto> mapOrderDto(Collection<OrderAvto> model) {
        return model.stream()
                .map(this::mapOrderDto)
                .collect(Collectors.toList());
    }
}
