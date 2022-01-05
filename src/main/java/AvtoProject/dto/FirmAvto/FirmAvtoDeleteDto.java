package AvtoProject.dto.FirmAvto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FirmAvtoDeleteDto {

    private final String firm;

    public FirmAvtoDeleteDto(@JsonProperty("firm") String firm) {

        this.firm = firm;
    }
}
