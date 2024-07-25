package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonEffectEntry {

    private String effect;
    @JsonAlias("short_effect")
    private String shortEffect;
    private PokemonNamedApiResource language;

}
