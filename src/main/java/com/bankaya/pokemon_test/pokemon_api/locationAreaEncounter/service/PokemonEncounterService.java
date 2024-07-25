package com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.service;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonEncounterResponse;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonLocationAreaItem;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PokemonEncounterService extends PokemonApiServiceBase<PokemonLocationAreaItem> {

    public PokemonEncounterResponse getLocationAreaEncounterByPokemonName(String name) throws PokemonBankayaException {
        String path = PokemonApiURLConstants.PATH_BASE.concat(name).concat(PokemonApiURLConstants.PATH_ENCOUNTERS);
        List<PokemonLocationAreaItem> areas = this.getList(path, PokemonLocationAreaItem[].class);
        if(areas != null) {
            return PokemonEncounterResponse.builder()
                    .locationAreaEncounters(areas)
                    .build();
        }

        String message = String.format("Sorry, we could not found your pokemon by name: %s", name);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
