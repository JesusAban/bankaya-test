package com.bankaya.pokemon_test.pokemon_api.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.models.Pokemon;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonAbility;
import com.bankaya.pokemon_test.pokemon_api.services.constants.PokemonApiURLConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonAbilityApiService extends PokemonApiServiceBase<PokemonAbility>{

    public List<PokemonAbility> getAllAbilitiesByPokemon(Pokemon pokemon) throws PokemonBankayaException {
        List<PokemonAbility> abilities = new ArrayList<>();

        if(pokemon != null) {

            pokemon.getAbilities().forEach(ability -> {
                String path = PokemonApiURLConstants.PATH_ABILITY.concat(ability.getAbility().getName());
                PokemonAbility abilityComplete = this.get(path, PokemonAbility.class);
                if (abilityComplete != null) {
                    abilities.add(abilityComplete);
                }
            });

        }
        return abilities;
    }


}
