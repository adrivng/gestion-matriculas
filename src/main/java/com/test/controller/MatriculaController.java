package com.test.controller;

import com.test.model.dto.MatriculaRequest;
import com.test.model.dto.MatriculaResponse;
import com.test.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<MatriculaResponse> matriculas() {
        return matriculaService.getMatriculas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatriculaResponse register(@Valid @RequestBody MatriculaRequest request) {
        return matriculaService.registerMatricula(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String id) {
        matriculaService.removeMatricula(id);
    }
}
