package com.bankaya.pokemon_test.exceptions;

import lombok.Getter;

@Getter
public class PokemonBankayaException extends RuntimeException {

    private final int statusCode;

    public PokemonBankayaException(String message) {
        this(message, 200);
    }

    public PokemonBankayaException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
