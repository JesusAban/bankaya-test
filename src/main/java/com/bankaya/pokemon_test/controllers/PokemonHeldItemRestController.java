package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.heldItem.models.PokemonHeldItemResponse;
import com.bankaya.pokemon_test.pokemon_api.heldItem.service.PokemonHeldItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon/{name}/held-items")
public class PokemonHeldItemRestController {

    private final PokemonHeldItemService pokemonHeldItemService;

    @Autowired
    public PokemonHeldItemRestController(final PokemonHeldItemService pokemonHeldItemService) {
        this.pokemonHeldItemService = pokemonHeldItemService;
    }

    @Tag(name = "Held Items", description = "Methods to retrieves the Pokemon's Held Items.")
    @Operation(
            summary = "Retrieves Pokemon's Held Items by pokemon name...",
            description = "Retrieve Pokemon's Held Items given us its name..."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<MessageResponse<PokemonHeldItemResponse>> getPokemonHeldItemsByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Held Items",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonHeldItemResponse heldItems = this.pokemonHeldItemService.getHeldItemByPokemonName(name);
            return MessageResponseBuilder.success(heldItems);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }
}
