package ms_estudiante.mapper;

import ms_estudiante.dto.EstudianteRequest;
import ms_estudiante.dto.EstudianteResponse;
import ms_estudiante.entity.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    EstudianteResponse toResponse(Estudiante estudiante);

    Estudiante toEntity(EstudianteRequest request);

    void updateEntity(@MappingTarget Estudiante estudiante, EstudianteRequest request);
}
