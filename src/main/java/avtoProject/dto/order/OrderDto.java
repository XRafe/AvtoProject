package avtoProject.dto.order;

import lombok.Getter;

@Getter
public class OrderDto {


    private final Integer id;

    private final Integer count;

    private final Integer sum;

    private final Integer model_id;

    private final Integer user_id;


    public OrderDto(Integer id, Integer count, Integer sum, Integer model_id, Integer user_id) {
        this.id = id;
        this.count = count;
        this.sum = sum;
        this.model_id = model_id;
        this.user_id = user_id;
    }
}
