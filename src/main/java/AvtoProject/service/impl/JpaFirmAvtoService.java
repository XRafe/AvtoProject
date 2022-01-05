package AvtoProject.service.impl;

import AvtoProject.dto.FirmAvto.FirmAvtoCreateDto;
import AvtoProject.dto.FirmAvto.FirmAvtoDeleteDto;
import AvtoProject.dto.FirmAvto.FirmAvtoDto;
import AvtoProject.entity.FirmAvto;
import AvtoProject.repository.FirmAvtoRepository;
import AvtoProject.service.FirmAvtoService;
import AvtoProject.service.factory.FirmAvtoFactory;
import AvtoProject.service.mapper.FirmAvtoMapper;
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
