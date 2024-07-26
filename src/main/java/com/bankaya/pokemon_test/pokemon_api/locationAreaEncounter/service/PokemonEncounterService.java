package com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.service;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.locationArea.PokemonLocationAreaService;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaDTO;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonEncounterResponse;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonLocationAreaEncounter;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonEncounterService extends PokemonApiServiceBase<PokemonLocationAreaEncounter> {

    private final PokemonLocationAreaService locationAreaService;

    @Autowired
    public PokemonEncounterService(final PokemonLocationAreaService locationAreaService) {
        this.locationAreaService = locationAreaService;
    }

    public PokemonEncounterResponse getLocationAreaEncounterByPokemonName(String name) throws PokemonBankayaException {
        String path = PokemonApiURLConstants.PATH_BASE.concat(name).concat(PokemonApiURLConstants.PATH_ENCOUNTERS);
        List<PokemonLocationAreaEncounter> locationAreas = this.getList(path, PokemonLocationAreaEncounter[].class);
        if(locationAreas != null) {
            List<PokemonLocationAreaDTO> locationAreaEncounters = new ArrayList<>();
            locationAreas.forEach(locationArea -> {
                locationAreaEncounters.addAll(this.locationAreaService.getAllLocationAreasByEncounterName(locationArea.getLocationArea().getName()));
            });
            return PokemonEncounterResponse.builder()
                    .locationAreaEncounters(locationAreaEncounters)
                    .build();
        }

        String message = String.format("Sorry, we could not found your pokemon by name: %s", name);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }

}
