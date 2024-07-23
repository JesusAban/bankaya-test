package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAbilityLazy {

    private Boolean is_hidden;
    private Integer slot;
    private PokemonNamedApiResourceLazy ability;

}
