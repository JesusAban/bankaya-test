package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonEffectChange {

    @JsonAlias("effect_entries")
    private List<PokemonEffect> effectEntries;
    @JsonAlias("version_group")
    private PokemonNamedApiResource versionGroup;

}
