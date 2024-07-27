package com.bankaya.pokemon_test.pokemon_api.pokemon.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.pokemon.models.*;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PokemonService extends PokemonApiServiceBase<Pokemon> {

    public PokemonIdResponse getPokemonIdByPokemonName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return PokemonIdResponse.builder()
                .id(pokemon.getId())
                .build();
    }

    public PokemonNameResponse getPokemonNameByName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return PokemonNameResponse.builder()
                .name(pokemon.getName())
                .build();
    }

    public PokemonExperienceResponse getBaseExperienceByPokemonName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return PokemonExperienceResponse.builder()
                .baseExperience(pokemon.getBaseExperience())
                .build();
    }

    public PokemonResponse getPokemonResponseByName(String name) throws PokemonBankayaException {
        return PokemonResponse
                .builder()
                .pokemon(this.getPokemonByName(name))
                .build();
    }

    public Pokemon getPokemonByName(String name) throws PokemonBankayaException {
        if(StringUtils.isEmpty(name)) {
            throw new PokemonBankayaException("Sorry, Pokemon's name should be different to null or blanks");
        }

        Pokemon pokemon = this.get(PokemonApiURLConstants.PATH_BASE.concat(name), Pokemon.class);
        if(pokemon != null && pokemon.getId() != null) {
            return pokemon;
        }

        String message = String.format("Sorry, we could not found your pokemon by name: %s", name);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
