package com.bankaya.pokemon_test.pokemon_api.location.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PokemonLocationDTO {

    private Integer id;
    private String name;
    private PokemonNamedApiResource region;
    private List<PokemonName> names;
    private List<PokemonNamedApiResource> areas;

}
