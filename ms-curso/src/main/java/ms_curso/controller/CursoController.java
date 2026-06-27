package ms_curso.controller;

import ms_curso.dto.CursoRequest;
import ms_curso.dto.CursoResponse;
import ms_curso.service.CursoService;
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
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CursoResponse> create(@RequestBody CursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> update(@PathVariable Long id, @RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
