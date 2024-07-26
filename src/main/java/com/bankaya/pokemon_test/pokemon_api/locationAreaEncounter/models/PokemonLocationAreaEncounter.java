package com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonLocationAreaEncounter {

    @JsonAlias("location_area")
    private PokemonNamedApiResource locationArea;

}
