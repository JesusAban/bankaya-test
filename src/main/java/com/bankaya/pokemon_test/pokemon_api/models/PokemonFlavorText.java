package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonFlavorText {

    private String flavor_text;
    private PokemonNamedApiResource language;
    private PokemonNamedApiResource version_group;

}
