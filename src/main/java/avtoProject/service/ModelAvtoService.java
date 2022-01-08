package avtoProject.service;

import avtoProject.dto.modelAvto.ModelAvtoCreateDto;
import avtoProject.dto.modelAvto.ModelAvtoDto;

import java.util.List;

public interface ModelAvtoService {

    List<ModelAvtoDto> getList();

    ModelAvtoDto createModelAvto(ModelAvtoCreateDto modelAvtoCreateDto);


}
