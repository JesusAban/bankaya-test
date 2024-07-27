package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonEffect {

    private String effect;
    private PokemonNamedApiResource language;

}
