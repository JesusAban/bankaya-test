package com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class PokemonEncounterMethod {

    private Integer id;
    private String name;
    private List<PokemonName> names;

}
