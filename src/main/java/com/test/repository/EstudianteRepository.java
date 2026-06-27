package com.test.repository;

import com.test.model.entity.EstudianteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, String> {
}
