package com.bankaya.pokemon_test.models;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class LogAdapter {

    private Instant date;
    private String sourceIP;
    private String method;
    private String urlRequest;
    private String response;
    private Integer statusCode;
    private String executionTime;

}
