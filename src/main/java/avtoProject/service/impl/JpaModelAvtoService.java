package avtoProject.service.impl;

import avtoProject.dto.modelAvto.ModelAvtoCreateDto;
import avtoProject.dto.modelAvto.ModelAvtoDto;
import avtoProject.entity.ModelAvto;
import avtoProject.repository.ModelAvtoRepository;
import avtoProject.service.ModelAvtoService;
import avtoProject.service.factory.ModelAvtoFactory;
import avtoProject.service.mapper.ModelAvtoMapper;
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
                modelAvtoCreateDto.getFirm_id()
        );
        modelAvto = modelAvtoRepository.saveAndFlush(modelAvto);

        return modelAvtoMapper.mapModelDto(modelAvto);
    }

}
