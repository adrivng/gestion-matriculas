package com.test.model.mapper;

import com.test.model.dto.CursoRequest;
import com.test.model.dto.CursoResponse;
import com.test.model.entity.CursoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoResponse toCursoResponse(CursoEntity entity);
    CursoEntity toCursoEntity(CursoRequest request);
}
