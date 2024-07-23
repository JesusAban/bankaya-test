package com.bankaya.pokemon_test.pokemon_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonHeldItem {

    private PokemonNamedApiResource item;
    private List<PokemonHeldItemVersion> version_details;

}
