package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.builders.PokemonEncounterBuilder;
import com.bankaya.pokemon_test.builders.constants.PokemonConstants;
import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonEncounterResponse;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.service.PokemonEncounterService;
import com.bankaya.pokemon_test.pokemon_api.services.constants.PokemonApiServiceBaseMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class PokemonEncounterRestControllerTest {

    @Mock
    private PokemonEncounterService pokemonEncounterService;

    @InjectMocks
    private PokemonEncounterRestController restController;

    @Test
    public void shouldReturnMessageErrorWhenPokemonApiIsDown() {
        String messageErrorExpected = String.format(
                PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API,
                PokemonApiURLConstants.PATH_ABILITY,
                "Error trying to consume Encounter service"
        );
        PokemonBankayaException exceptionExpected = new PokemonBankayaException(messageErrorExpected, HttpStatus.NOT_FOUND.value());
        ResponseEntity<MessageResponse<PokemonEncounterResponse>> messageExpected = MessageResponseBuilder.error(exceptionExpected);

        Mockito.doThrow(exceptionExpected)
                .when(this.pokemonEncounterService)
                .getLocationAreaEncounterByPokemonName(Mockito.anyString());

        ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseEncounters = this.restController.getLocationAreaEncounterByPokemonName(PokemonConstants.Gengar.NAME);
        this.assertMessage(responseEncounters, messageExpected);
        this.assertMessageError(responseEncounters, exceptionExpected);
    }

    @Test
    public void shouldReturnMessageSuccess() {
        PokemonEncounterResponse encounterResponse = PokemonEncounterBuilder.getPokemonEncounterResponse();

        ResponseEntity<MessageResponse<PokemonEncounterResponse>> messageExpected = MessageResponseBuilder.success(encounterResponse);

        Mockito.when(this.pokemonEncounterService.getLocationAreaEncounterByPokemonName(Mockito.anyString()))
                .thenReturn(encounterResponse);

        ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseAbilities = this.restController.getLocationAreaEncounterByPokemonName(PokemonConstants.Gengar.NAME);
        this.assertMessage(responseAbilities, messageExpected);
        this.assertMessageSuccess(responseAbilities, encounterResponse);
    }

    private void assertMessageSuccess(ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseEncountersSuccess, PokemonEncounterResponse abilityResponseExpected) {
        Assertions.assertEquals(Objects.requireNonNull(responseEncountersSuccess.getBody()).getData().getLocationAreaEncounters().size(), abilityResponseExpected.getLocationAreaEncounters().size());
        Assertions.assertEquals(responseEncountersSuccess.getBody().getData().getLocationAreaEncounters().get(0).getId(), abilityResponseExpected.getLocationAreaEncounters().get(0).getId());
        Assertions.assertEquals(responseEncountersSuccess.getBody().getData().getLocationAreaEncounters().get(0).getName(), abilityResponseExpected.getLocationAreaEncounters().get(0).getName());
    }

    private void assertMessageError(ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseAbilitiesError, PokemonBankayaException exceptionExpected) {
        Assertions.assertEquals(exceptionExpected.getStatusCode(), responseAbilitiesError.getStatusCode().value());
        Assertions.assertEquals(exceptionExpected.getMessage(), Objects.requireNonNull(responseAbilitiesError.getBody()).getMessage());
    }

    private void assertMessage(ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseEncounters, ResponseEntity<MessageResponse<PokemonEncounterResponse>> responseEncounterExpected) {
        Assertions.assertNotNull(responseEncounters.getBody());
        Assertions.assertNotNull(responseEncounters.getBody().getMessage());
        Assertions.assertNotNull(responseEncounters.getStatusCode());

        Assertions.assertEquals(Objects.requireNonNull(responseEncounterExpected.getBody()).getMessage(), responseEncounters.getBody().getMessage());
        Assertions.assertEquals(responseEncounterExpected.getStatusCode(), responseEncounters.getStatusCode());
    }
}
