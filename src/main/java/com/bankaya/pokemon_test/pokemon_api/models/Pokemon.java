package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {

    private Integer id;
    private String name;
    private List<PokemonHeldItem> held_items;
    private String location_area_encounter;
    private Integer base_experience;
    private List<PokemonAbilityLazy> abilities;

}
