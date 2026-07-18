package ms_matricula.service;

import ms_matricula.dto.MatriculaRequest;
import ms_matricula.dto.MatriculaResponse;
import ms_matricula.entity.Matricula;
import ms_matricula.mapper.MatriculaMapper;
import ms_matricula.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;
    private final RestTemplate restTemplate;

    public MatriculaService(MatriculaRepository matriculaRepository,
                            MatriculaMapper matriculaMapper,
                            RestTemplate restTemplate) {
        this.matriculaRepository = matriculaRepository;
        this.matriculaMapper = matriculaMapper;
        this.restTemplate = restTemplate;
    }

    public List<MatriculaResponse> findAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(matriculaMapper::toResponse)
                .toList();
    }

    public MatriculaResponse findById(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));
        return matriculaMapper.toResponse(matricula);
    }

    @SuppressWarnings("unchecked")
    public MatriculaResponse create(MatriculaRequest request) {
        validarCurso(request.getCursoId());
        validarEstudiante(request.getEstudianteId());

        Matricula matricula = matriculaMapper.toEntity(request);
        matricula.setEstado("ACTIVA");
        matricula = matriculaRepository.save(matricula);
        return matriculaMapper.toResponse(matricula);
    }

    public MatriculaResponse update(Long id, MatriculaRequest request) {
        validarCurso(request.getCursoId());
        validarEstudiante(request.getEstudianteId());

        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));
        matriculaMapper.updateEntity(matricula, request);
        matricula = matriculaRepository.save(matricula);
        return matriculaMapper.toResponse(matricula);
    }

    public void delete(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("Matricula no encontrada con id: " + id);
        }
        matriculaRepository.deleteById(id);
    }

    private void validarCurso(Long cursoId) {
        try {
            restTemplate.getForEntity(
                    "http://ms-curso:8081/api/cursos/{id}",
                    Map.class,
                    cursoId
            );
        } catch (Exception e) {
            throw new RuntimeException("El curso con id " + cursoId + " no existe: " + e.getMessage(), e);
        }
    }

    private void validarEstudiante(Long estudianteId) {
        try {
            restTemplate.getForEntity(
                    "http://ms-estudiante:8082/api/estudiantes/{id}",
                    Map.class,
                    estudianteId
            );
        } catch (Exception e) {
            throw new RuntimeException("El estudiante con id " + estudianteId + " no existe: " + e.getMessage(), e);
        }
    }
}
