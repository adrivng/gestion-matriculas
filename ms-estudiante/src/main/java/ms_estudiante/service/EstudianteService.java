package ms_estudiante.service;

import ms_estudiante.dto.EstudianteRequest;
import ms_estudiante.dto.EstudianteResponse;
import ms_estudiante.entity.Estudiante;
import ms_estudiante.mapper.EstudianteMapper;
import ms_estudiante.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    public EstudianteService(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    public List<EstudianteResponse> findAll() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toResponse)
                .toList();
    }

    public EstudianteResponse findById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
        return estudianteMapper.toResponse(estudiante);
    }

    public EstudianteResponse create(EstudianteRequest request) {
        Estudiante estudiante = estudianteMapper.toEntity(request);
        estudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.toResponse(estudiante);
    }

    public EstudianteResponse update(Long id, EstudianteRequest request) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
        estudianteMapper.updateEntity(estudiante, request);
        estudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.toResponse(estudiante);
    }

    public void delete(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con id: " + id);
        }
        estudianteRepository.deleteById(id);
    }
}
