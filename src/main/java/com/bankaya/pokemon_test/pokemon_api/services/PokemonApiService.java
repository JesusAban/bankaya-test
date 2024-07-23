package com.bankaya.pokemon_test.pokemon_api.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.models.Pokemon;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonHeldItem;
import com.bankaya.pokemon_test.pokemon_api.services.constants.PokemonApiURLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PokemonApiService extends PokemonApiServiceBase<Pokemon> {

    public Integer getPokemonIdByPokemonName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return pokemon.getId();
    }

    public String getPokemonNameByName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return pokemon.getName();
    }

    public List<PokemonHeldItem> getPokemonHeldItemsByPokemonName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return pokemon.getHeld_items();
    }

    public Integer getBaseExperienceByPokemonName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.getPokemonByName(name);
        return pokemon.getBase_experience();
    }

    public Pokemon getPokemonByName(String name) throws PokemonBankayaException {
        Pokemon pokemon = this.get(PokemonApiURLConstants.PATH_BASE.concat(name), Pokemon.class);
        if(pokemon != null && pokemon.getId() != null) {
            return pokemon;
        }

        String message = String.format("Sorry, we could not found your pokemon by name: %s", name);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
