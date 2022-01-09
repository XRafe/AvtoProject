package avtoproject.service.mapper;

import avtoproject.dto.firmAvto.FirmAvtoDto;
import avtoproject.entity.FirmAvto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FirmAvtoMapper {

    public FirmAvtoDto mapFirmDto(FirmAvto model) {
        return new FirmAvtoDto(
                model.getId(),
                model.getFirm()
        );
    }

    public List<FirmAvtoDto> mapFirmDto(Collection<FirmAvto> model) {
        return model.stream()
                .map(this::mapFirmDto)
                .collect(Collectors.toList());
    }

}
