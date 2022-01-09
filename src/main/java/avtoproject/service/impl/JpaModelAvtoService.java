package avtoproject.service.impl;

import avtoproject.dto.modelAvto.ModelAvtoCreateDto;
import avtoproject.dto.modelAvto.ModelAvtoDto;
import avtoproject.entity.ModelAvto;
import avtoproject.repository.ModelAvtoRepository;
import avtoproject.service.ModelAvtoService;
import avtoproject.service.factory.ModelAvtoFactory;
import avtoproject.service.mapper.ModelAvtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaModelAvtoService implements ModelAvtoService {


    private final ModelAvtoFactory modelAvtoFactory;

    private final ModelAvtoRepository modelAvtoRepository;

    private final ModelAvtoMapper modelAvtoMapper;


    public JpaModelAvtoService(ModelAvtoFactory modelAvtoFactory,
                               ModelAvtoRepository modelAvtoRepository,
                               ModelAvtoMapper modelAvtoMapper) {
        this.modelAvtoFactory = modelAvtoFactory;
        this.modelAvtoRepository = modelAvtoRepository;
        this.modelAvtoMapper = modelAvtoMapper;
    }

    @Override
    public List<ModelAvtoDto> getList() {
        List<ModelAvto> models = modelAvtoRepository.findAll();
        return modelAvtoMapper.mapModelDto(models);
    }

    @Transactional
    @Override
    public ModelAvtoDto createModelAvto(ModelAvtoCreateDto modelAvtoCreateDto) {
        ModelAvto modelAvto = modelAvtoFactory.build(
                modelAvtoCreateDto.getModel(),
                modelAvtoCreateDto.getPrice(),
                modelAvtoCreateDto.getFirmId()
        );
        modelAvto = modelAvtoRepository.saveAndFlush(modelAvto);

        return modelAvtoMapper.mapModelDto(modelAvto);
    }

}
