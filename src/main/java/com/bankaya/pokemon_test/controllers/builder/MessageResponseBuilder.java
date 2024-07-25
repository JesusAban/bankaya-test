package com.bankaya.pokemon_test.controllers.builder;

import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class MessageResponseBuilder {

    private MessageResponseBuilder() { }

    public static <T> ResponseEntity<MessageResponse<T>> success(T item) {
        return ResponseEntity.ok(
                MessageResponse.<T>builder()
                        .message("Success")
                        .code(HttpStatus.OK.value())
                        .data(item)
                        .build()
        );
    }

    public static <T> ResponseEntity<MessageResponse<T>> error(PokemonBankayaException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body(
                        MessageResponse.<T>builder()
                                .message("Success")
                                .code(HttpStatus.OK.value())
                                .build()
                );
    }
}
