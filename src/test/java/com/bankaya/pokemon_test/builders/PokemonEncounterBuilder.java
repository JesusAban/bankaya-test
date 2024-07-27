package com.bankaya.pokemon_test.builders;

import com.bankaya.pokemon_test.builders.constants.PokemonEncounterConstants;
import com.bankaya.pokemon_test.pokemon_api.encounterMethodRate.models.PokemonEncounterMethod;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaBaseDTO;
import com.bankaya.pokemon_test.pokemon_api.locationArea.models.PokemonLocationAreaDTO;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonEncounterResponse;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;

import java.util.ArrayList;
import java.util.List;

public class PokemonEncounterBuilder {

    private PokemonEncounterBuilder() { }

    public static PokemonEncounterResponse getPokemonEncounterResponse() {
        return PokemonEncounterResponse
                .builder()
                .locationAreaEncounters(PokemonEncounterBuilder.getEncounters())
                .build();

    }

    private static List<PokemonLocationAreaDTO> getEncounters() {
        List<PokemonLocationAreaDTO> encounters=  new ArrayList<>();
        encounters.add(getEncounter());
        return encounters;
    }

    private static PokemonLocationAreaDTO getEncounter() {
        return PokemonLocationAreaDTO.builder()
                .id(PokemonEncounterConstants.EncounterOldChateauEntrance.ID)
                .name(PokemonEncounterConstants.EncounterOldChateauEntrance.NAME_CODE)
                .encounterMethodRates(PokemonEncounterBuilder.getMethodRates())
                .names(PokemonEncounterBuilder.getLocationAreaNames())
                .locations(PokemonEncounterBuilder.getLocations())
                .build();
    }

    private static List<PokemonEncounterMethod> getMethodRates() {
        List<PokemonEncounterMethod> encounterMethods = new ArrayList<>();
        encounterMethods.add(PokemonEncounterBuilder.walkMethodEncounter());
        return encounterMethods;
    }

    private static PokemonEncounterMethod walkMethodEncounter() {
        PokemonEncounterMethod walkMethod = new PokemonEncounterMethod();
        walkMethod.setId(PokemonEncounterConstants.WalkEncounterMethod.ID);
        walkMethod.setName(PokemonEncounterConstants.WalkEncounterMethod.NAME_ID);
        walkMethod.setNames(getWalkNamesMethodEncounter());

        return walkMethod;
    }

    private static List<PokemonName> getWalkNamesMethodEncounter() {
        List<PokemonName> walkNamesMethodEncounter = new ArrayList<>();
        walkNamesMethodEncounter.add(PokemonEncounterBuilder.getWalkNameInEnglish());
        return walkNamesMethodEncounter;
    }

    private static PokemonName getWalkNameInEnglish() {
        PokemonName walkName = new PokemonName();
        walkName.setName(PokemonEncounterConstants.WalkEncounterMethod.NAME);
        walkName.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());

        return walkName;
    }

    private static List<PokemonName> getLocationAreaNames() {
        List<PokemonName> locationAreaNames = new ArrayList<>();
        locationAreaNames.add(PokemonEncounterBuilder.getLocationArea2FName());
        return locationAreaNames;
    }

    private static PokemonName getLocationArea2FName() {
        PokemonName locationAreaName = new PokemonName();
        locationAreaName.setName(PokemonEncounterConstants.WalkEncounterMethod.NAME_OLD_CHATEAU_2F);
        locationAreaName.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());
        return locationAreaName;
    }

    private static List<PokemonLocationAreaBaseDTO> getLocations(){
        List<PokemonLocationAreaBaseDTO> locations = new ArrayList<>();
        locations.add(PokemonEncounterBuilder.getLocation());
        return locations;
    }

    private static PokemonLocationAreaBaseDTO getLocation() {
        return PokemonLocationAreaBaseDTO.builder()
                .id(PokemonEncounterConstants.LocationOldChateuEntrance.ID)
                .name(PokemonEncounterConstants.LocationOldChateuEntrance.NAME_ID)
                .names(PokemonEncounterBuilder.getLocationNamesOld())
                .build();
    }

    private static List<PokemonName> getLocationNamesOld() {
        List<PokemonName> locationsNameOld = new ArrayList<>();
        locationsNameOld.add(PokemonEncounterBuilder.getLocationNameOld());
        return locationsNameOld;
    }

    private static PokemonName getLocationNameOld() {
        PokemonName locationNameOld = new PokemonName();
        locationNameOld.setName(PokemonEncounterConstants.LocationOldChateuEntrance.NAME);
        locationNameOld.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());
        return locationNameOld;
    }
}

