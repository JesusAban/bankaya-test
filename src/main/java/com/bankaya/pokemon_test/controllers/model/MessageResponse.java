package com.bankaya.pokemon_test.controllers.model;

import lombok.*;
import lombok.experimental.Accessors;

@Builder
@Getter
public class MessageResponse {

    private Object data;
    private String message;
    private int code;

}
