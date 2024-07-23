package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonAbility {

    private Integer id;
    private String name;
    private Boolean is_main_series;
    private PokemonNamedApiResource generation;
    private List<PokemonName> names;
    private List<PokemonEffectEntry> effect_entries;
    private List<PokemonEffectChange> effect_changes;
    private List<PokemonFlavorText> flavor_text_entries;

}
