package avtoproject.service;

import avtoproject.dto.firmAvto.FirmAvtoCreateDto;
import avtoproject.dto.firmAvto.FirmAvtoDto;

import java.util.List;

public interface FirmAvtoService {

    List<FirmAvtoDto> getList();

    FirmAvtoDto createFirmAvto(FirmAvtoCreateDto firmAvtoCreateDto);

}
