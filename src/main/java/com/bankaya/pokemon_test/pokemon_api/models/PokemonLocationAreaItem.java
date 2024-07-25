package com.bankaya.pokemon_test.pokemon_api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonLocationAreaItem {

    @JsonAlias("location_area")
    private PokemonLocationAreaEncounter locationArea;

}
