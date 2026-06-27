package com.test.service;

import com.test.model.dto.MatriculaRequest;
import com.test.model.dto.MatriculaResponse;

import java.util.List;

public interface MatriculaService {
    MatriculaResponse registerMatricula(MatriculaRequest request);
    List<MatriculaResponse> getMatriculas();
    void removeMatricula(String id);
}
