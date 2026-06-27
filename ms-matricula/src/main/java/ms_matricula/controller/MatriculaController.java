package ms_matricula.controller;

import ms_matricula.dto.MatriculaRequest;
import ms_matricula.dto.MatriculaResponse;
import ms_matricula.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponse>> findAll() {
        return ResponseEntity.ok(matriculaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MatriculaResponse> create(@RequestBody MatriculaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponse> update(@PathVariable Long id, @RequestBody MatriculaRequest request) {
        return ResponseEntity.ok(matriculaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
