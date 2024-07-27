package com.bankaya.pokemon_test.pokemon_api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonVersionGroupFlavorText {

    private String text;
    private PokemonNamedApiResource language;
    @JsonAlias("version_group")
    private PokemonNamedApiResource versionGroup;

}
