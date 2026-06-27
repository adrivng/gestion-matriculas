package com.test.controller;

import com.test.model.dto.CursoRequest;
import com.test.model.dto.CursoResponse;
import com.test.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoResponse> cursos() {
        return cursoService.getCursos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponse register(@Valid @RequestBody CursoRequest request) {
        return cursoService.registerCurso(request);
    }

    @PutMapping
    public CursoResponse update(@Valid @RequestBody CursoRequest request) {
        return cursoService.updateCurso(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String id) {
        cursoService.removeCurso(id);
    }
}
