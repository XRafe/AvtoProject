package avtoproject.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderCreateDto {

    private final Integer count;

    private final Integer sum;

    private final Integer modelId;

    private final Integer userId;

    public OrderCreateDto(@JsonProperty("count") Integer count,
                          @JsonProperty("sum") Integer sum,
                          @JsonProperty("userId") Integer userId,
                          @JsonProperty("modelId") Integer modelId) {
        this.count = count;
        this.sum = sum;
        this.userId = userId;
        this.modelId = modelId;
    }
}
