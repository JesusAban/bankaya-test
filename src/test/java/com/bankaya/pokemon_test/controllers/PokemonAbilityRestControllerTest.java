package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.builders.PokemonAbilityBuilder;
import com.bankaya.pokemon_test.builders.constants.PokemonConstants;
import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityResponse;
import com.bankaya.pokemon_test.pokemon_api.ability.services.PokemonAbilityService;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
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
public class PokemonAbilityRestControllerTest {

    @Mock
    private PokemonAbilityService pokemonAbilityService;

    @InjectMocks
    private PokemonAbilityRestController restController;

    @Test
    public void shouldReturnMessageErrorWhenPokemonApiServiceBaseFails() {
        String messageErrorExpected = String.format(
                PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API,
                PokemonApiURLConstants.PATH_ABILITY,
                "Error trying to consume Ability service"
        );
        PokemonBankayaException exceptionExpected = new PokemonBankayaException(messageErrorExpected, HttpStatus.NOT_FOUND.value());
        ResponseEntity<MessageResponse<PokemonAbilityResponse>> messageExpected = MessageResponseBuilder.error(exceptionExpected);

        Mockito.doThrow(exceptionExpected)
                .when(this.pokemonAbilityService)
                .getAllAbilitiesByPokemonName(Mockito.anyString());

        ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilities = this.restController.getAllAbilitiesByPokemon(PokemonConstants.Gengar.NAME);
        this.assertMessage(responseAbilities, messageExpected);
        this.assertMessageError(responseAbilities, exceptionExpected);
    }

    @Test
    public void shouldReturnMessageSuccess() {
        PokemonAbilityResponse abilityResponseExpected = PokemonAbilityBuilder.getAbilityResponse();

        ResponseEntity<MessageResponse<PokemonAbilityResponse>> messageExpected = MessageResponseBuilder.success(abilityResponseExpected);

        Mockito.when(this.pokemonAbilityService.getAllAbilitiesByPokemonName(Mockito.anyString()))
                .thenReturn(abilityResponseExpected);

        ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilities = this.restController.getAllAbilitiesByPokemon(PokemonConstants.Gengar.NAME);
        this.assertMessage(responseAbilities, messageExpected);
        this.assertMessageSuccess(responseAbilities, abilityResponseExpected);
    }

    private void assertMessageSuccess(ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilitiesSuccess, PokemonAbilityResponse abilityResponseExpected) {
        Assertions.assertEquals(Objects.requireNonNull(responseAbilitiesSuccess.getBody()).getData().getAbilities().size(), abilityResponseExpected.getAbilities().size());
        Assertions.assertEquals(responseAbilitiesSuccess.getBody().getData().getAbilities().get(0).getId(), abilityResponseExpected.getAbilities().get(0).getId());
        Assertions.assertEquals(responseAbilitiesSuccess.getBody().getData().getAbilities().get(0).getName(), abilityResponseExpected.getAbilities().get(0).getName());
    }

    private void assertMessageError(ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilitiesError, PokemonBankayaException exceptionExpected) {
        Assertions.assertEquals(exceptionExpected.getStatusCode(), responseAbilitiesError.getStatusCode().value());
        Assertions.assertEquals(exceptionExpected.getMessage(), Objects.requireNonNull(responseAbilitiesError.getBody()).getMessage());
    }

    private void assertMessage(ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilities, ResponseEntity<MessageResponse<PokemonAbilityResponse>> responseAbilitiesExpected) {
        Assertions.assertNotNull(responseAbilities.getBody());
        Assertions.assertNotNull(responseAbilities.getBody().getMessage());
        Assertions.assertNotNull(responseAbilities.getStatusCode());

        Assertions.assertEquals(Objects.requireNonNull(responseAbilitiesExpected.getBody()).getMessage(), responseAbilities.getBody().getMessage());
        Assertions.assertEquals(responseAbilitiesExpected.getStatusCode(), responseAbilities.getStatusCode());
    }


}
