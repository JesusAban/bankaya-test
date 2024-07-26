package com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethod;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonEncounterMethodService extends PokemonApiServiceBase<PokemonEncounterMethod> {

    public PokemonEncounterMethod getEncounterMethodByName(String encounterMethodName) throws PokemonBankayaException {
        String path = PokemonApiURLConstants.PATH_ENCOUNTER_METHOD.concat(encounterMethodName);
        PokemonEncounterMethod encounterMethod = this.get(path, PokemonEncounterMethod.class);
        if(encounterMethod != null) {
            return encounterMethod;
        }

        String message = String.format("Sorry, we could not found your encounter method by name: %s", encounterMethodName);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
