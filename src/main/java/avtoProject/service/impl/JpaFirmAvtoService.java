package avtoProject.service.impl;

import avtoProject.dto.firmAvto.FirmAvtoCreateDto;
import avtoProject.dto.firmAvto.FirmAvtoDto;
import avtoProject.entity.FirmAvto;
import avtoProject.repository.FirmAvtoRepository;
import avtoProject.service.FirmAvtoService;
import avtoProject.service.factory.FirmAvtoFactory;
import avtoProject.service.mapper.FirmAvtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaFirmAvtoService implements FirmAvtoService {

    private final FirmAvtoFactory firmAvtoFactory;

    private final FirmAvtoRepository firmAvtoRepository;

    private final FirmAvtoMapper firmAvtoMapper;

    public JpaFirmAvtoService(FirmAvtoFactory firmAvtoFactory,
                              FirmAvtoRepository firmAvtoRepository,
                              FirmAvtoMapper firmAvtoMapper) {
        this.firmAvtoFactory = firmAvtoFactory;
        this.firmAvtoRepository = firmAvtoRepository;
        this.firmAvtoMapper = firmAvtoMapper;
    }

    @Override
    public List<FirmAvtoDto> getList() {
        List<FirmAvto> firms = firmAvtoRepository.findAll();
        return firmAvtoMapper.mapFirmDto(firms);
    }


    @Transactional
    @Override
    public FirmAvtoDto createFirmAvto(FirmAvtoCreateDto firmAvtoCreateDto) {
        FirmAvto firmAvto = firmAvtoFactory.build(
                firmAvtoCreateDto.getFirm()
        );
        firmAvto = firmAvtoRepository.saveAndFlush(firmAvto);
        return firmAvtoMapper.mapFirmDto(firmAvto);
    }


}
