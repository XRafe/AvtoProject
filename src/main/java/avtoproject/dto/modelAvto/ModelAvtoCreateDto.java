package avtoproject.dto.modelAvto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModelAvtoCreateDto {

    private final String model;

    private final Integer price;

    private final Integer firmId;

    public ModelAvtoCreateDto(@JsonProperty("model") String model,
                              @JsonProperty("price") Integer price,
                              @JsonProperty("firm_id") Integer firmId) {
        this.model = model;
        this.price = price;
        this.firmId = firmId;
    }
}
