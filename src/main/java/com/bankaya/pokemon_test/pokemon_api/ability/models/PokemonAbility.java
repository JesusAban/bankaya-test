package com.bankaya.pokemon_test.pokemon_api.ability.models;

import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonEffectChange;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonEffectEntry;
import com.bankaya.pokemon_test.pokemon_api.models.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonAbility {

    private Integer id;
    private String name;
    @JsonAlias("is_main_series")
    private Boolean mainSeries;
    private PokemonNamedApiResource generation;
    private List<PokemonName> names;
    @JsonAlias("effect_entries")
    private List<PokemonEffectEntry> effectEntries;
    @JsonAlias("effect_changes")
    private List<PokemonEffectChange> effectChanges;
    @JsonAlias("flavor_text_entries")
    private List<PokemonAbilityFlavorText> flavorTextEntries;

}
