package com.bankaya.pokemon_test.services;

import com.bankaya.pokemon_test.entities.LogEntity;
import com.bankaya.pokemon_test.mapper.LogMapper;
import com.bankaya.pokemon_test.models.LogAdapter;
import com.bankaya.pokemon_test.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(final LogRepository logRepository){
        this.logRepository = logRepository;
    }

    @Override
    public void saveLog(LogAdapter log) {
        LogEntity entity = LogMapper.logAdapterToEntity(log);
        this.logRepository.save(entity);
    }

    @Override
    public List<LogEntity> getAll() {
        try {
            return this.logRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
