package AvtoProject.service.factory;

import AvtoProject.entity.ModelAvto;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;

@Component
public class ModelAvtoFactory {

    public ModelAvto build(String model, Integer price, Integer firm_id) {
        return new ModelAvto(model, price, firm_id);
    }
}
