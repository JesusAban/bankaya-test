package com.bankaya.pokemon_test.builders;

import com.bankaya.pokemon_test.builders.constants.PokemonGlobalConstants;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;

public class PokemonGlobalBuilder {
    public static PokemonNamedApiResource getEnglishLanguage() {
        PokemonNamedApiResource language = new PokemonNamedApiResource();
        language.setName(PokemonGlobalConstants.ENGLISH_LANGUAGE);
        return language;
    }
}
