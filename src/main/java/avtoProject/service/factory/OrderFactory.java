package avtoProject.service.factory;

import avtoProject.entity.OrderAvto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    public OrderAvto build(Integer count, Integer sum, Integer user_id, Integer model_id) {
        return new OrderAvto(count, sum, user_id, model_id);
    }
}
