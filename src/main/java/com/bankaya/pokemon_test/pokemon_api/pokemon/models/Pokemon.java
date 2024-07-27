package com.bankaya.pokemon_test.pokemon_api.pokemon.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {

    private Integer id;
    private String name;
    @JsonAlias("held_items")
    private List<PokemonHeldItemLazy> heldItems;
    @JsonAlias("location_area_encounter")
    private String locationAreaEncounter;
    @JsonAlias("base_experience")
    private Integer baseExperience;
    private List<PokemonAbilityLazy> abilities;

}
