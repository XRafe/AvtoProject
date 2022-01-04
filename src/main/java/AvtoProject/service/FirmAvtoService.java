package AvtoProject.service;

import AvtoProject.dto.FirmAvto.FirmAvtoCreateDto;
import AvtoProject.dto.FirmAvto.FirmAvtoDto;


import java.util.List;

public interface FirmAvtoService {

    List<FirmAvtoDto> getList();

    FirmAvtoDto createFirmAvto(FirmAvtoCreateDto firmAvtoCreateDto);

}
