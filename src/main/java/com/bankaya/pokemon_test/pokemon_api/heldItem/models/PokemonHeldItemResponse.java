package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PokemonHeldItemResponse {

    private List<PokemonHeldItem> heldItems;

}
