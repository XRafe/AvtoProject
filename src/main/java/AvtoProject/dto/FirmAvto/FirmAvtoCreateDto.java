package AvtoProject.dto.FirmAvto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FirmAvtoCreateDto {

    private final String firm;

    public FirmAvtoCreateDto(@JsonProperty("firm") String firm) {

        this.firm = firm;
    }
}
