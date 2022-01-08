package avtoProject.service.factory;

import avtoProject.entity.ModelAvto;
import org.springframework.stereotype.Component;

@Component
public class ModelAvtoFactory {

    public ModelAvto build(String model, Integer price, Integer firmId) {
        return new ModelAvto(model, price, firmId);
    }
}
