package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityResponse;
import com.bankaya.pokemon_test.pokemon_api.ability.services.PokemonAbilityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PokemonAbilityRestControllerTest {

    @Mock
    private PokemonAbilityService pokemonAbilityService;

    @InjectMocks
    private PokemonAbilityRestController restController;

    @Test
    public void something() {
        Mockito.doThrow(new PokemonBankayaException("Error", 404))
                .when(this.pokemonAbilityService)
                .getAllAbilitiesByPokemonName(Mockito.anyString());

        ResponseEntity<MessageResponse<PokemonAbilityResponse>> myPokemon = this.restController.getAllAbilitiesByPokemon("my pokemon");
        Assertions.assertEquals(404, myPokemon.getStatusCode().value());
    }


}
