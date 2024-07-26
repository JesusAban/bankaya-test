package com.bankaya.pokemon_test.pokemon_api.location.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.location.models.PokemonLocation;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonLocationService extends PokemonApiServiceBase<PokemonLocation> {

    public PokemonLocation getLocationByName(String locationName) throws PokemonBankayaException {
        String path = PokemonApiURLConstants.PATH_LOCATION.concat(locationName);
        PokemonLocation pokemonLocation = this.get(path, PokemonLocation.class);
        if(pokemonLocation != null) {
            return pokemonLocation;
        }

        String message = String.format("Sorry, we could not found your location by name: %s", locationName);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
