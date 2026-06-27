package com.test.repository;

import com.test.model.entity.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, String> {
}
