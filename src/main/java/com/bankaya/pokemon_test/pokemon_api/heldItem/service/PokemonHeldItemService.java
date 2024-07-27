package com.bankaya.pokemon_test.pokemon_api.heldItem.service;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.constants.PokemonApiURLConstants;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonHeldItemResponse;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonHeldItem;
import com.bankaya.pokemon_test.pokemon_api.pokemon.models.Pokemon;
import com.bankaya.pokemon_test.pokemon_api.pokemon.services.PokemonService;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonHeldItemService extends PokemonApiServiceBase<PokemonHeldItem> {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonHeldItemService(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public PokemonHeldItemResponse getHeldItemByPokemonName(String pokemonName) throws PokemonBankayaException {
        Pokemon pokemon = this.pokemonService.getPokemonByName(pokemonName);

        List<PokemonHeldItem> heldItems = new ArrayList<>();
        pokemon.getHeldItems().forEach(heldItemLazy -> {
            String path = PokemonApiURLConstants.PATH_HELD_ITEM.concat(heldItemLazy.getItem().getName());
            PokemonHeldItem heldItem = this.get(path, PokemonHeldItem.class);
            heldItems.add(heldItem);
        });

        return PokemonHeldItemResponse.builder()
                .heldItems(heldItems)
                .build();
    }
}
