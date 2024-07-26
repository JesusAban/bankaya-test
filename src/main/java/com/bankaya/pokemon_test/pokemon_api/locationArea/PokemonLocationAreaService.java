package com.bankaya.pokemon_test.pokemon_api.locationArea;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethod;
import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.services.PokemonEncounterMethodService;
import com.bankaya.pokemon_test.pokemon_api.location.models.PokemonLocation;
import com.bankaya.pokemon_test.pokemon_api.location.services.PokemonLocationService;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationArea;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaBaseDTO;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaDTO;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLocationAreaService extends PokemonApiServiceBase<PokemonLocationArea> {

    private final PokemonEncounterMethodService encounterMethodService;
    private final PokemonLocationService locationService;

    @Autowired
    public PokemonLocationAreaService(final PokemonEncounterMethodService encounterMethodService,
                                      final PokemonLocationService locationService) {
        this.encounterMethodService = encounterMethodService;
        this.locationService = locationService;
    }

    public List<PokemonLocationAreaDTO> getAllLocationAreasByEncounterName(String encounterName) throws PokemonBankayaException {
        String path = PokemonApiURLConstants.PATH_LOCATION_AREA.concat(encounterName);
        PokemonLocationArea locationArea = this.get(path, PokemonLocationArea.class);
        if(locationArea != null) {
            List<PokemonLocationAreaDTO> locationAreasDTO = new ArrayList<>();


                List<PokemonEncounterMethod> encounterMethods = new ArrayList<>();
                locationArea.getEncounterMethodRates().forEach(encounterMethodRate -> {
                    PokemonEncounterMethod encounterMethod = this.encounterMethodService.getEncounterMethodByName(encounterMethodRate.getEncounterMethod().getName());
                    encounterMethods.add(encounterMethod);
                });

                PokemonLocation location = this.locationService.getLocationByName(locationArea.getLocation().getName());

                List<PokemonLocationAreaBaseDTO> locationsDTO = new ArrayList<>();
                location.getAreas().forEach(area -> {
                    PokemonLocationArea locationAreaTemp = this.get(PokemonApiURLConstants.PATH_LOCATION_AREA.concat(area.getName()), PokemonLocationArea.class);
                    PokemonLocationAreaBaseDTO locationAreaDTO = PokemonLocationAreaBaseDTO
                            .builder()
                            .names(locationAreaTemp.getNames())
                            .name(locationAreaTemp.getName())
                            .id(locationAreaTemp.getId())
                            .build();
                    locationsDTO.add(locationAreaDTO);
                });

                PokemonLocationAreaDTO locationAreaDTO = PokemonLocationAreaDTO.builder()
                        .id(locationArea.getId())
                        .name(locationArea.getName())
                        .names(locationArea.getNames())
                        .encounterMethodRates(encounterMethods)
                        .locations(locationsDTO)
                        .build();

                locationAreasDTO.add(locationAreaDTO);

            return locationAreasDTO;
        }

        String message = String.format("Sorry, we could not found your location areas by encounter name: %s", encounterName);
        throw new PokemonBankayaException(message, HttpStatus.NOT_FOUND.value());
    }
}
