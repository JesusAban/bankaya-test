package com.bankaya.pokemon_test.controllers.builder;

import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class MessageResponseBuilder {

    private MessageResponseBuilder() { }

    public static ResponseEntity<MessageResponse> success(Object item) {
        return ResponseEntity.ok(
                MessageResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("Success")
                    .data(item)
                    .build()
        );
    }

    public static ResponseEntity<MessageResponse> error(PokemonBankayaException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body(
                        MessageResponse.builder()
                            .code(e.getStatusCode())
                            .message(e.getMessage())
                            .build()
                );
    }
}
