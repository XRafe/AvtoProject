package AvtoProject.dto.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderCreateDto {

    private final Integer count;

    private final Integer sum;

    private final Integer model_id;

    private final Integer user_id;

    public OrderCreateDto(@JsonProperty("count") Integer count,
                          @JsonProperty("sum") Integer sum,
                          @JsonProperty("user_id") Integer user_id,
                          @JsonProperty("model_id") Integer model_id) {
        this.count = count;
        this.sum = sum;
        this.user_id = user_id;
        this.model_id = model_id;
    }
}
