package com.test.repository;

import com.test.model.entity.NotaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends CrudRepository<NotaEntity,Long> {
}
