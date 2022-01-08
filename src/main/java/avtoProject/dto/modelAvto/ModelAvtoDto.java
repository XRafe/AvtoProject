package avtoProject.dto.modelAvto;

import lombok.Getter;

@Getter
public class ModelAvtoDto {

    private final Integer id;

    private final String model;

    private final Integer price;

    private final Integer firmId;

    public ModelAvtoDto(Integer id, String model, Integer price, Integer firmId) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.firmId = firmId;
    }
}
