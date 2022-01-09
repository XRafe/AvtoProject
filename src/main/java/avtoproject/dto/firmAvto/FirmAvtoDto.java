package avtoproject.dto.firmAvto;

import lombok.Getter;

@Getter
public class FirmAvtoDto {

    private final Integer id;

    private final String firm;

    public FirmAvtoDto(Integer id, String firm) {
        this.id = id;
        this.firm = firm;
    }
}
