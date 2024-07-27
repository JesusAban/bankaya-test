package com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonEncounterMethodLazy {

    @JsonAlias("encounter_method")
    private PokemonNamedApiResource encounterMethod;

}
