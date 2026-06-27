package com.test.service.impl;

import com.test.exception.ResourceNotFoundException;
import com.test.model.dto.MatriculaRequest;
import com.test.model.dto.MatriculaResponse;
import com.test.model.entity.CursoEntity;
import com.test.model.entity.EstudianteEntity;
import com.test.model.mapper.MatriculaMapper;
import com.test.repository.CursoRepository;
import com.test.repository.EstudianteRepository;
import com.test.repository.MatriculaRepository;
import com.test.service.MatriculaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository repository;
    private final MatriculaMapper mapper;
    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;

    public MatriculaServiceImpl(MatriculaRepository repository, MatriculaMapper mapper,
                                CursoRepository cursoRepository, EstudianteRepository estudianteRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    @Transactional
    public MatriculaResponse registerMatricula(MatriculaRequest request) {
        var entity = new com.test.model.entity.MatriculaEntity();
        entity.setIdMatricula(request.getIdMatricula());
        entity.setPeriodo(request.getPeriodo());
        entity.setNivel(request.getNivel());
        entity.setFecha_mat(request.getFecha_mat());

        var cursos = request.getCursos().stream()
                .map(id -> cursoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Curso no existe: " + id)))
                .toList();
        entity.setCursos(cursos);

        var estudiantes = request.getEstudiantes().stream()
                .map(id -> estudianteRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Estudiante no existe: " + id)))
                .toList();
        entity.setEstudiantes(estudiantes);

        repository.save(entity);
        return mapper.toMatriculaResponse(entity);
    }

    @Override
    public List<MatriculaResponse> getMatriculas() {
        return ((List<com.test.model.entity.MatriculaEntity>) repository.findAll())
                .stream()
                .map(mapper::toMatriculaResponse)
                .toList();
    }

    @Override
    @Transactional
    public void removeMatricula(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matrícula no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
