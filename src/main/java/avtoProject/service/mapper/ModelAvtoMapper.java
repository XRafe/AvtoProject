package avtoProject.service.mapper;

import avtoProject.dto.modelAvto.ModelAvtoDto;
import avtoProject.entity.ModelAvto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelAvtoMapper {

    public ModelAvtoDto mapModelDto(ModelAvto model) {
        return new ModelAvtoDto(
                model.getId(),
                model.getModel(),
                model.getPrice(),
                model.getFirmId()
        );
    }

    public List<ModelAvtoDto> mapModelDto(Collection<ModelAvto> model) {
        return model.stream()
                .map(this::mapModelDto)
                .collect(Collectors.toList());
    }
}
