package com.bankaya.pokemon_test.repositories;

import com.bankaya.pokemon_test.entities.LogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Long> {

    List<LogEntity> findAll();
}
