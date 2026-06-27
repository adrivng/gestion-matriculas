package com.test.service;

import com.test.model.dto.CursoRequest;
import com.test.model.dto.CursoResponse;

import java.util.List;

public interface CursoService {
    CursoResponse registerCurso(CursoRequest request);
    List<CursoResponse> getCursos();
    CursoResponse updateCurso(CursoRequest request);
    void removeCurso(String id);
}
