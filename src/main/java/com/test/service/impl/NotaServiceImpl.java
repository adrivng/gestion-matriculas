package com.test.service.impl;

import com.test.exception.ResourceNotFoundException;
import com.test.model.dto.NotaRequest;
import com.test.model.dto.NotaResponse;
import com.test.model.entity.NotaEntity;
import com.test.model.mapper.NotaMapper;
import com.test.repository.NotaRepository;
import com.test.service.NotaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository repository;
    private final NotaMapper mapper;

    public NotaServiceImpl(NotaRepository repository, NotaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public NotaResponse registrarNota(NotaRequest request) {
        NotaEntity entity = mapper.toNotaEntity(request);
        repository.save(entity);
        return mapper.toNotaResponse(entity);
    }

    @Override
    public List<NotaResponse> getNotas() {
        return ((List<NotaEntity>) repository.findAll())
                .stream()
                .map(mapper::toNotaResponse)
                .toList();
    }

    @Override
    @Transactional
    public void removeNota(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Nota no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
