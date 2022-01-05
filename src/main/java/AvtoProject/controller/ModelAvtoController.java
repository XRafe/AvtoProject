package AvtoProject.controller;

import AvtoProject.dto.ModelAvto.ModelAvtoCreateDto;
import AvtoProject.dto.ModelAvto.ModelAvtoDto;
import AvtoProject.dto.ModelAvto.ModelAvtoEditDto;
import AvtoProject.service.ModelAvtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelavto")
@CrossOrigin(origins = "http://localhost:4200")
public class ModelAvtoController {

    private final ModelAvtoService modelAvtoService;

    public ModelAvtoController(ModelAvtoService modelAvtoService) {
        this.modelAvtoService = modelAvtoService;
    }

    @GetMapping
    public List<ModelAvtoDto> getList() {
        return modelAvtoService.getList();
    }

    @PostMapping
    public ModelAvtoDto createModelAvto(@RequestBody ModelAvtoCreateDto modelAvtoCreateDto) {
        return modelAvtoService.createModelAvto(modelAvtoCreateDto);
    }



}
