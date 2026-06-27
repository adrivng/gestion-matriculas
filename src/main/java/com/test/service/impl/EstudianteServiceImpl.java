package com.test.service.impl;

import com.test.exception.ResourceNotFoundException;
import com.test.model.dto.EstudianteRequest;
import com.test.model.dto.EstudianteResponse;
import com.test.model.mapper.EstudianteMapper;
import com.test.repository.EstudianteRepository;
import com.test.service.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;
    private final EstudianteMapper mapper;

    public EstudianteServiceImpl(EstudianteRepository repository, EstudianteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public EstudianteResponse registerEstudiante(EstudianteRequest request) {
        var entity = mapper.toEstudianteEntity(request);
        repository.save(entity);
        return mapper.toEstudianteResponse(entity);
    }

    @Override
    public List<EstudianteResponse> getEstudiantes() {
        return ((List<com.test.model.entity.EstudianteEntity>) repository.findAll())
                .stream()
                .map(mapper::toEstudianteResponse)
                .toList();
    }

    @Override
    @Transactional
    public EstudianteResponse updateEstudiante(EstudianteRequest request) {
        var estudiante = repository.findById(request.getIdEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + request.getIdEstudiante()));
        estudiante.setNombre(request.getNombre());
        estudiante.setApellido(request.getApellido());
        estudiante.setDireccion(request.getDireccion());
        estudiante.setTelefono(request.getTelefono());
        repository.save(estudiante);
        return mapper.toEstudianteResponse(estudiante);
    }

    @Override
    @Transactional
    public void removeEstudiante(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Estudiante no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
