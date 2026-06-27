package com.test.controller;

import com.test.model.dto.NotaRequest;
import com.test.model.dto.NotaResponse;
import com.test.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<NotaResponse> notas() {
        return notaService.getNotas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotaResponse registrar(@Valid @RequestBody NotaRequest request) {
        return notaService.registrarNota(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        notaService.removeNota(id);
    }
}
