package ms_curso.service;

import ms_curso.dto.CursoRequest;
import ms_curso.dto.CursoResponse;
import ms_curso.entity.Curso;
import ms_curso.mapper.CursoMapper;
import ms_curso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    public List<CursoResponse> findAll() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public CursoResponse findById(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
        return cursoMapper.toResponse(curso);
    }

    public CursoResponse create(CursoRequest request) {
        Curso curso = cursoMapper.toEntity(request);
        curso = cursoRepository.save(curso);
        return cursoMapper.toResponse(curso);
    }

    public CursoResponse update(Long id, CursoRequest request) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
        cursoMapper.updateEntity(curso, request);
        curso = cursoRepository.save(curso);
        return cursoMapper.toResponse(curso);
    }

    public void delete(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado con id: " + id);
        }
        cursoRepository.deleteById(id);
    }
}
