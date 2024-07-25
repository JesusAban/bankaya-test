package com.bankaya.pokemon_test.pokemon_api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonVerboseEffect {

    private String effect;
    @JsonAlias("short_effect")
    private String shortEffect;
    private PokemonNamedApiResource language;

}
