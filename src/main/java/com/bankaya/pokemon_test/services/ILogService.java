package com.bankaya.pokemon_test.services;

import com.bankaya.pokemon_test.entities.LogEntity;
import com.bankaya.pokemon_test.models.LogAdapter;

import java.util.List;

public interface ILogService {

    void saveLog(LogAdapter log);

    List<LogEntity> getAll();

}
