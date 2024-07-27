package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.bankaya.pokemon_test.pokemon_api.models.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonHeldItem {

    private Integer id;
    private String name;
    private Integer cost;
    @JsonAlias("fling_power")
    private Integer flingPower;
    @JsonAlias("fling_effect")
    private PokemonNamedApiResource flingEffect;
    private List<PokemonNamedApiResource> attributes;
    private PokemonNamedApiResource category;
    @JsonAlias("effect_entries")
    private List<PokemonVerboseEffect> effectEntries;
    @JsonAlias("flavor_text_entries")
    private List<PokemonVersionGroupFlavorText> flavorTextEntries;
    private List<PokemonName> names;
    private PokemonItemSprites sprites;
    @JsonAlias("held_by_pokemon")
    private List<PokemonItemHolder> heldByPokemon;
    @JsonAlias("baby_trigger_for")
    private PokemonApiResource babyTriggerFor;

}
