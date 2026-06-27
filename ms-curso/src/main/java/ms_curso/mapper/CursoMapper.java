package ms_curso.mapper;

import ms_curso.dto.CursoRequest;
import ms_curso.dto.CursoResponse;
import ms_curso.entity.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoResponse toResponse(Curso curso);

    Curso toEntity(CursoRequest request);

    void updateEntity(@MappingTarget Curso curso, CursoRequest request);
}
