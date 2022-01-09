package avtoproject.dto.order;

import lombok.Getter;

@Getter
public class OrderDto {


    private final Integer id;

    private final Integer count;

    private final Integer sum;

    private final Integer modelId;

    private final Integer userId;


    public OrderDto(Integer id, Integer count, Integer sum, Integer modelId, Integer userId) {
        this.id = id;
        this.count = count;
        this.sum = sum;
        this.modelId = modelId;
        this.userId = userId;
    }
}
