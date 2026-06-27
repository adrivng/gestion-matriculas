package com.test.service;

import com.test.model.dto.NotaRequest;
import com.test.model.dto.NotaResponse;

import java.util.List;

public interface NotaService {

    NotaResponse registrarNota(NotaRequest request);
    List<NotaResponse> getNotas();
    void removeNota(Long id);
}
