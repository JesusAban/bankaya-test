package com.bankaya.pokemon_test.pokemon_api.locationArea.models;

import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethod;
import com.bankaya.pokemon_test.pokemon_api.location.models.PokemonLocation;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@AllArgsConstructor
@SuperBuilder
public class PokemonLocationAreaBaseDTO {

    private Integer id;
    private String name;
    private List<PokemonName> names;

}
