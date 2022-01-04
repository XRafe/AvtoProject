package AvtoProject.dto.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderEditDto {
    private final Integer count;

    private final Integer sum;

    public OrderEditDto(@JsonProperty("count") Integer count,
                        @JsonProperty("sum") Integer sum) {
        this.count = count;
        this.sum = sum;
    }
}
