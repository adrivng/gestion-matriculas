package com.test.service.impl;

import com.test.exception.ResourceNotFoundException;
import com.test.model.dto.CursoRequest;
import com.test.model.dto.CursoResponse;
import com.test.model.mapper.CursoMapper;
import com.test.repository.CursoRepository;
import com.test.service.CursoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoServiceImpl(CursoRepository repository, CursoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public CursoResponse registerCurso(CursoRequest request) {
        var entity = mapper.toCursoEntity(request);
        repository.save(entity);
        return mapper.toCursoResponse(entity);
    }

    @Override
    public List<CursoResponse> getCursos() {
        return ((List<com.test.model.entity.CursoEntity>) repository.findAll())
                .stream()
                .map(mapper::toCursoResponse)
                .toList();
    }

    @Override
    @Transactional
    public CursoResponse updateCurso(CursoRequest request) {
        var curso = repository.findById(request.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado: " + request.getIdCurso()));
        curso.setNombreCurso(request.getNombreCurso());
        curso.setSemestre(request.getSemestre());
        curso.setTitulo(request.getTitulo());
        curso.setCreditos(request.getCreditos());
        repository.save(curso);
        return mapper.toCursoResponse(curso);
    }

    @Override
    @Transactional
    public void removeCurso(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Curso no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
