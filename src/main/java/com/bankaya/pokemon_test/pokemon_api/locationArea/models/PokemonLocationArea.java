package com.bankaya.pokemon_test.pokemon_api.locationArea.models;

import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethodLazy;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonLocationArea {

    private Integer id;
    private String name;
    @JsonAlias("encounter_method_rates")
    private List<PokemonEncounterMethodLazy> encounterMethodRates;
    private PokemonNamedApiResource location;
    private List<PokemonName> names;

}
