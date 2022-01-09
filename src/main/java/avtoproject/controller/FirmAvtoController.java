package avtoproject.controller;

import avtoproject.dto.firmAvto.FirmAvtoCreateDto;
import avtoproject.dto.firmAvto.FirmAvtoDto;
import avtoproject.service.FirmAvtoService;
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
    public FirmAvtoDto createFirmAvto(@RequestBody FirmAvtoCreateDto firmAvtoCreateDto) {
        return firmAvtoService.createFirmAvto(firmAvtoCreateDto);
    }

}
