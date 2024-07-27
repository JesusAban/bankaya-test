package com.bankaya.pokemon_test.pokemon_api.ability.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityResponse;
import com.bankaya.pokemon_test.pokemon_api.pokemon.models.Pokemon;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbility;
import com.bankaya.pokemon_test.pokemon_api.pokemon.services.PokemonService;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonAbilityService extends PokemonApiServiceBase<PokemonAbility> {

    private final PokemonService pokemonApiService;

    @Autowired
    public PokemonAbilityService(final PokemonService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    public PokemonAbilityResponse getAllAbilitiesByPokemonName(String pokemonName) throws PokemonBankayaException {
        Pokemon pokemon = this.pokemonApiService.getPokemonByName(pokemonName);

        List<PokemonAbility> abilities = new ArrayList<>();

        pokemon.getAbilities().forEach(ability -> {
            String path = PokemonApiURLConstants.PATH_ABILITY.concat(ability.getAbility().getName());
            PokemonAbility abilityComplete = this.get(path, PokemonAbility.class);
            if (abilityComplete != null) {
                abilities.add(abilityComplete);
            }
        });

        return PokemonAbilityResponse.builder()
                .abilities(abilities)
                .build();
    }


}
