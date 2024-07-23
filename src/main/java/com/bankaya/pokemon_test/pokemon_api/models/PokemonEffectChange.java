package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonEffectChange {

    private List<PokemonEffect> effect_entries;
    private PokemonNamedApiResource version_group;

}
