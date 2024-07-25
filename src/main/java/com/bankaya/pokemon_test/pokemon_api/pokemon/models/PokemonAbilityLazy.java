package com.bankaya.pokemon_test.pokemon_api.pokemon.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAbilityLazy {

    @JsonAlias("is_hidden")
    private Boolean hidden;
    private Integer slot;
    private PokemonNamedApiResource ability;

}
