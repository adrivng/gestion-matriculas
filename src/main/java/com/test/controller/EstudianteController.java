package com.test.controller;

import com.test.model.dto.EstudianteRequest;
import com.test.model.dto.EstudianteResponse;
import com.test.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<EstudianteResponse> estudiantes() {
        return estudianteService.getEstudiantes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstudianteResponse register(@Valid @RequestBody EstudianteRequest request) {
        return estudianteService.registerEstudiante(request);
    }

    @PutMapping
    public EstudianteResponse update(@Valid @RequestBody EstudianteRequest request) {
        return estudianteService.updateEstudiante(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String id) {
        estudianteService.removeEstudiante(id);
    }
}
