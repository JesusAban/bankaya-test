package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonEffectEntry {

    private String effect;
    private String short_effect;
    private PokemonNamedApiResource language;

}
