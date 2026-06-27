package com.test.model.mapper;

import com.test.model.dto.MatriculaResponse;
import com.test.model.entity.MatriculaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    MatriculaResponse toMatriculaResponse(MatriculaEntity entity);
}
