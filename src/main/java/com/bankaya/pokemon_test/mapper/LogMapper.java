package com.bankaya.pokemon_test.mapper;

import com.bankaya.pokemon_test.entities.LogEntity;
import com.bankaya.pokemon_test.models.LogAdapter;

import java.sql.Timestamp;

public abstract class LogMapper {

    public static LogEntity logAdapterToEntity(LogAdapter logAdapter) {
        LogEntity entity = new LogEntity();
        entity.setDate(Timestamp.from(logAdapter.getDate()));
        entity.setStatusCode(logAdapter.getStatusCode());
        entity.setSourceIP(logAdapter.getSourceIP());
        entity.setMethod(logAdapter.getMethod());
        entity.setUrlRequest(logAdapter.getUrlRequest());
        entity.setExecutionTime(logAdapter.getExecutionTime());
        entity.setResponse(logAdapter.getResponse());

        return entity;
    }

}
