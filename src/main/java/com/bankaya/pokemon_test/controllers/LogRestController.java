package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.entities.LogEntity;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.services.ILogService;
import com.bankaya.pokemon_test.services.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogRestController {

    private final ILogService pokemonAbilityService;

    @Autowired
    public LogRestController(final LogServiceImpl pokemonAbilityService) {
        this.pokemonAbilityService = pokemonAbilityService;
    }

    @GetMapping
    public ResponseEntity<MessageResponse<List<LogEntity>>> getAllLogs() {
        try {
            List<LogEntity> abilities = this.pokemonAbilityService.getAll();
            return MessageResponseBuilder.success(abilities);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }
}
