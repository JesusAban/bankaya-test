package com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models;

import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PokemonEncounterResponse {

    private List<PokemonLocationAreaDTO> locationAreaEncounters;

}
