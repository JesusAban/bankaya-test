package com.bankaya.pokemon_test.pokemon_api.ability.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAbilityFlavorText {

    @JsonAlias("flavor_text")
    private String flavorText;
    private PokemonNamedApiResource language;
    @JsonAlias("version_group")
    private PokemonNamedApiResource versionGroup;

}
