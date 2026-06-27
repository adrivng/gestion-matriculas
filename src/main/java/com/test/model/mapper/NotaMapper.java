package com.test.model.mapper;

import com.test.model.dto.NotaRequest;
import com.test.model.dto.NotaResponse;
import com.test.model.entity.NotaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    NotaResponse toNotaResponse(NotaEntity entity);
    NotaEntity toNotaEntity(NotaRequest request);
}

