package ms_matricula.mapper;

import ms_matricula.dto.MatriculaRequest;
import ms_matricula.dto.MatriculaResponse;
import ms_matricula.entity.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    MatriculaResponse toResponse(Matricula matricula);

    Matricula toEntity(MatriculaRequest request);

    void updateEntity(@MappingTarget Matricula matricula, MatriculaRequest request);
}
