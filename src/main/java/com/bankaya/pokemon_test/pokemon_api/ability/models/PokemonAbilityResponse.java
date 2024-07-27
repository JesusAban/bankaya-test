package com.bankaya.pokemon_test.pokemon_api.ability.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class PokemonAbilityResponse {

    private List<PokemonAbility> abilities;

}
