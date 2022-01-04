package AvtoProject.service;

import AvtoProject.dto.ModelAvto.ModelAvtoCreateDto;
import AvtoProject.dto.ModelAvto.ModelAvtoDto;
import AvtoProject.dto.ModelAvto.ModelAvtoEditDto;

import java.util.List;

public interface ModelAvtoService {

    List<ModelAvtoDto> getList();

    ModelAvtoDto createModelAvto(ModelAvtoCreateDto modelAvtoCreateDto);




}
