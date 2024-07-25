package com.bankaya.pokemon_test.controllers.model;

import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
public class MessageResponse<T> {

    private T data;
    private String message;
    private int code;

}
