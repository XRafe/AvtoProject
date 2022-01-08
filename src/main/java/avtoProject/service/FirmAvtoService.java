package avtoProject.service;

import avtoProject.dto.firmAvto.FirmAvtoCreateDto;
import avtoProject.dto.firmAvto.FirmAvtoDto;

import java.util.List;

public interface FirmAvtoService {

    List<FirmAvtoDto> getList();

    FirmAvtoDto createFirmAvto(FirmAvtoCreateDto firmAvtoCreateDto);

}
