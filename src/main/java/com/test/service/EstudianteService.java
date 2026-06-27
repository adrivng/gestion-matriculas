package com.test.service;

import com.test.model.dto.EstudianteRequest;
import com.test.model.dto.EstudianteResponse;

import java.util.List;

public interface EstudianteService {
    EstudianteResponse registerEstudiante(EstudianteRequest request);
    List<EstudianteResponse> getEstudiantes();
    EstudianteResponse updateEstudiante(EstudianteRequest request);
    void removeEstudiante(String id);
}
