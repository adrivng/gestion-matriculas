package com.test.repository;

import com.test.model.entity.MatriculaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<MatriculaEntity, String> {
}
