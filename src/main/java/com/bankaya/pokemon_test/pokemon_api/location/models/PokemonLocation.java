package com.bankaya.pokemon_test.pokemon_api.location.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonLocation {

    private Integer id;
    private String name;
    private PokemonNamedApiResource region;
    private List<PokemonName> names;
    private List<PokemonNamedApiResource> areas;

}
