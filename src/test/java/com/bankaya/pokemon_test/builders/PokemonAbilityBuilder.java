package com.bankaya.pokemon_test.builders;

import com.bankaya.pokemon_test.builders.constants.PokemonAbilityConstants;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbility;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityFlavorText;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityResponse;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonEffectChange;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonEffectEntry;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonName;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonNamedApiResource;

import java.util.ArrayList;
import java.util.List;

public class PokemonAbilityBuilder {

    private PokemonAbilityBuilder() { }

    public static PokemonAbilityResponse getAbilityResponse() {
        return PokemonAbilityResponse
                .builder()
                .abilities(PokemonAbilityBuilder.getAbilities())
                .build();
    }

    private static List<PokemonAbility> getAbilities() {
        List<PokemonAbility> abilities = new ArrayList<>();
        abilities.add(PokemonAbilityBuilder.getCursedBodyAbility());
        return abilities;
    }

    private static PokemonAbility getCursedBodyAbility() {
        PokemonAbility ability = new PokemonAbility();
        ability.setId(PokemonAbilityConstants.CoursedBody.ID);
        ability.setName(PokemonAbilityConstants.CoursedBody.NAME_CODE);
        ability.setGeneration(PokemonAbilityBuilder.getGeneration());
        ability.setNames(PokemonAbilityBuilder.getNames());
        ability.setEffectEntries(PokemonAbilityBuilder.getCoursedBodyEffects());
        ability.setMainSeries(Boolean.TRUE);
        ability.setFlavorTextEntries(PokemonAbilityBuilder.getCoursedBodyFlavorTexts());
        ability.setEffectChanges(PokemonAbilityBuilder.getEffectChanges());

        return ability;
    }

    private static PokemonNamedApiResource getGeneration() {
        PokemonNamedApiResource generation = new PokemonNamedApiResource();
        generation.setName(PokemonAbilityConstants.CoursedBody.GENERATION_NAME);
        return generation;
    }

    private static List<PokemonName> getNames() {
        List<PokemonName> names = new ArrayList<>();
        names.add(PokemonAbilityBuilder.getEnglishName());
        return names;
    }

    private static PokemonName getEnglishName() {
        PokemonName englishName = new PokemonName();
        englishName.setName(PokemonAbilityConstants.CoursedBody.NAME);
        englishName.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());
        return englishName;
    }

    private static List<PokemonEffectEntry> getCoursedBodyEffects() {
        List<PokemonEffectEntry> effects = new ArrayList<>();
        effects.add(PokemonAbilityBuilder.getCoursedBodyEffectEntry());
        return effects;
    }

    private static PokemonEffectEntry getCoursedBodyEffectEntry() {
        PokemonEffectEntry effectEntry = new PokemonEffectEntry();
        effectEntry.setEffect(PokemonAbilityConstants.CoursedBody.EFFECT);
        effectEntry.setShortEffect(PokemonAbilityConstants.CoursedBody.SHORT_EFFECT);
        effectEntry.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());

        return effectEntry;
    }

    private static List<PokemonAbilityFlavorText> getCoursedBodyFlavorTexts() {
        List<PokemonAbilityFlavorText> flavorTexts= new ArrayList<>();
        flavorTexts.add(PokemonAbilityBuilder.getCoursedBodyFlavorText());
        return flavorTexts;
    }

    private static PokemonAbilityFlavorText getCoursedBodyFlavorText() {
        PokemonAbilityFlavorText flavorText = new PokemonAbilityFlavorText();
        flavorText.setFlavorText(PokemonAbilityConstants.CoursedBody.FLAVOR_TEXT);
        flavorText.setLanguage(PokemonGlobalBuilder.getEnglishLanguage());
        flavorText.setVersionGroup(getFlavorVersionGroup());
        return flavorText;
    }

    private static  PokemonNamedApiResource getFlavorVersionGroup() {
        PokemonNamedApiResource flavorVersionGroup = new PokemonNamedApiResource();
        flavorVersionGroup.setName(PokemonAbilityConstants.CoursedBody.FLAVOR_TEXT_VERSION);
        return flavorVersionGroup;
    }

    private static List<PokemonEffectChange> getEffectChanges() {
        return new ArrayList<>();
    }

}
