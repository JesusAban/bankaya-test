package com.bankaya.pokemon_test.pokemon_api.heldItem.models;

import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonItemHolder {

    private PokemonNamedApiResource pokemon;
    @JsonAlias("version_details")
    private List<PokemonItemHolderVersionDetail> versionDetails;
}
