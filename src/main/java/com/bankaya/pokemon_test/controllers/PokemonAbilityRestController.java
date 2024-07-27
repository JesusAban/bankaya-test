package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.ability.models.PokemonAbilityResponse;
import com.bankaya.pokemon_test.pokemon_api.ability.services.PokemonAbilityService;
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
@RequestMapping("/pokemon/{name}/abilities")
public class PokemonAbilityRestController {

    private final PokemonAbilityService pokemonAbilityService;

    @Autowired
    public PokemonAbilityRestController(final PokemonAbilityService pokemonAbilityService) {
        this.pokemonAbilityService = pokemonAbilityService;
    }

    @Tag(name = "Abilities", description = "Methods to retrieves the Pokemon's Abilities.")
    @Operation(
            summary = "Retrieves Pokemon's Abilities by pokemon name",
            description = "Retrieve Pokemon's Abilities given us its name"
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
    public ResponseEntity<MessageResponse<PokemonAbilityResponse>> getAllAbilitiesByPokemon(
            @Parameter(
                    description = "Pokemon's name to retrieve its Abilities",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonAbilityResponse abilities = this.pokemonAbilityService.getAllAbilitiesByPokemonName(name);
            return MessageResponseBuilder.success(abilities);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }
}
