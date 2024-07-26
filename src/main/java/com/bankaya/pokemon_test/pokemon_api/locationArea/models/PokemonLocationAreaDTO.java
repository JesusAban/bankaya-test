package com.bankaya.pokemon_test.pokemon_api.locationArea.models;


import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethod;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class PokemonLocationAreaDTO extends PokemonLocationAreaBaseDTO {

    private List<PokemonLocationAreaBaseDTO> locations;
    private List<PokemonEncounterMethod> encounterMethodRates;

}
