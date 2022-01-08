package avtoProject.service.factory;

import avtoProject.entity.OrderAvto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    public OrderAvto build(Integer count, Integer sum, Integer userId, Integer modelId) {
        return new OrderAvto(count, sum, userId, modelId);
    }
}
