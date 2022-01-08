package avtoProject.dto.modelAvto;

import lombok.Getter;

@Getter
public class ModelAvtoDto {

    private final Integer id;

    private final String model;

    private final Integer price;

    private final Integer firm_id;

    public ModelAvtoDto(Integer id, String model, Integer price, Integer firm_id) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.firm_id = firm_id;
    }
}
