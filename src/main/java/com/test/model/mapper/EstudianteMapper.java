package com.test.model.mapper;

import com.test.model.dto.EstudianteRequest;
import com.test.model.dto.EstudianteResponse;
import com.test.model.entity.EstudianteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    EstudianteResponse toEstudianteResponse(EstudianteEntity entity);
    EstudianteEntity toEstudianteEntity(EstudianteRequest request);
}
