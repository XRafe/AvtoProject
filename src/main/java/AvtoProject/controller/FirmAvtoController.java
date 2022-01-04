package AvtoProject.controller;

import AvtoProject.dto.FirmAvto.FirmAvtoDeleteDto;
import AvtoProject.dto.FirmAvto.FirmAvtoCreateDto;
import AvtoProject.dto.FirmAvto.FirmAvtoDto;
import AvtoProject.service.FirmAvtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firmavto")
@CrossOrigin(origins = "http://localhost:4200")
public class FirmAvtoController {

    private final FirmAvtoService firmAvtoService;

    public FirmAvtoController(FirmAvtoService firmAvtoService) {

        this.firmAvtoService = firmAvtoService;
    }

    @GetMapping
    public List<FirmAvtoDto> getList() {

        return firmAvtoService.getList();
    }

    @PostMapping
    public FirmAvtoDto createFirmAvto(@RequestBody FirmAvtoCreateDto firmAvtoCreateDto){
        return firmAvtoService.createFirmAvto(firmAvtoCreateDto);
    }

}
