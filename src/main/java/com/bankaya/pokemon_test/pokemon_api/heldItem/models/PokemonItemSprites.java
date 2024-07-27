package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonItemSprites {

    @JsonAlias("default")
    private String defaultSprite;

}
