package avtoProject.dto.modelAvto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModelAvtoCreateDto {

    private final String model;

    private final Integer price;

    private final Integer firm_id;

    public ModelAvtoCreateDto(@JsonProperty("model") String model,
                              @JsonProperty("price") Integer price,
                              @JsonProperty("firm_id") Integer firm_id) {
        this.model = model;
        this.price = price;
        this.firm_id = firm_id;
    }
}
