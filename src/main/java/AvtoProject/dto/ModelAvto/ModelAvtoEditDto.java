package AvtoProject.dto.ModelAvto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModelAvtoEditDto {

    private final String model;

    private final Integer price;

    public ModelAvtoEditDto(@JsonProperty("model") String model,
                            @JsonProperty("price") Integer price) {
        this.model = model;
        this.price = price;
    }
}
