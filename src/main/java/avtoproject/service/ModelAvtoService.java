package avtoproject.service;

import avtoproject.dto.modelAvto.ModelAvtoCreateDto;
import avtoproject.dto.modelAvto.ModelAvtoDto;

import java.util.List;

public interface ModelAvtoService {

    List<ModelAvtoDto> getList();

    ModelAvtoDto createModelAvto(ModelAvtoCreateDto modelAvtoCreateDto);


}
